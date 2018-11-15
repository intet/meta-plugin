package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.dto.ufs.APIIMType;
import com.sbrf.meta.plugin.dto.ufs.ExceptionType;
import com.sbrf.meta.plugin.dto.ufs.ParamType;
import com.sbrf.meta.plugin.dto.ufs.ReturnTypeType;
import com.sbrf.meta.plugin.dto.xml.InputType;
import com.sbrf.meta.plugin.dto.xml.MethodType;
import com.sbrf.meta.plugin.dto.xml.ThrowsType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sbrf.meta.plugin.asm.util.DtoUtils.getClassType;

public class ApiMethodInfo {
    public final String technicalName;
    public final String signature;
    public final String logicalName;
    public final String version;
    public final List<String> input;
    public List<String> inputName;
    public final List<String> throwsList;
    public final String output;
    public final Set<ApiCall> invocations = new HashSet<>();
    private String comment;

    public ApiMethodInfo(String logicalName, String technicalName, String signature, String version,
                         List<String> input, String output, List<String> throwsList) {
        this.technicalName = technicalName;
        this.logicalName = logicalName;
        this.signature = signature;
        this.version = version;
        this.input = input;
        this.output = output;
        this.throwsList = throwsList;
    }

    public void addCall(String className, GAV gav) {
        invocations.add(new ApiCall(className, gav));
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("logicalName", logicalName);
        result.put("technicalName", technicalName);
        result.put("version", version);
        JSONArray inputArray = new JSONArray();
        for (String className : input) {
            inputArray.put(className);
        }
        result.put("input", inputArray);
        JSONArray throwsArray = new JSONArray();
        for (String throwItem : throwsList) {
            throwsArray.put(throwItem);
        }
        result.put("throws", throwsArray);
        result.put("output", this.output);
        JSONArray callArray = new JSONArray();
        for (ApiCall call : invocations) {
            callArray.put(call.toJson());
        }
        result.put("invocations", callArray);
        result.put("comment", comment);
        return result;
    }

    public void addParamsName(List<String> paramsName) {
        inputName = paramsName;
    }

    public void addComment(String comment) {
        this.comment = comment;
    }

    public MethodType toXml() {
        MethodType result = new MethodType();
        result.setLogicalName(logicalName);
        result.setTechnicalName(technicalName);
        result.setVersion(version);

        for (int i = 0; i < input.size(); i++) {
            InputType inputType = new InputType();
            inputType.setClazz(getClassType(input.get(i)));
            if (inputName != null) {
                inputType.setName(inputName.get(i));
            } else {
                inputType.setName("none");
            }
            result.getInput().add(inputType);
        }

        ThrowsType throwsArray = new ThrowsType();
        for (String throwItem : throwsList) {
            throwsArray.getThrows().add(throwItem);
        }
        result.setThrows(throwsArray);
        result.setOutput(getClassType(this.output));
        result.setComment(comment);
        result.setSignature(signature);
        return result;
    }

    public APIIMType toUfs(ApiInfo apiInfo) {
        APIIMType apiimType = new APIIMType();
        apiimType.setApiId(signature);
        apiimType.setImInterfaceName(apiInfo.apiClass);
        apiimType.setComment(comment);
        {
            ReturnTypeType returnType = new ReturnTypeType();
            boolean isArray = false;
            String out = output;
            if (output.endsWith("[]")) {
                isArray = true;
                out = out.replace("[]", "");
            }

            returnType.setPackageName(output.substring(0, out.lastIndexOf(".")));
            returnType.setTypeName(output.substring(out.lastIndexOf(".")));
            returnType.setIsArray(isArray);
            apiimType.setReturnType(returnType);
        }
        for (String in : input) {
            ParamType param = new ParamType();
            boolean isArray = false;
            if (output.endsWith("[]")) {
                isArray = true;
                in = in.replace("[]", "");
            }
            param.setPackageName(output.substring(0, in.lastIndexOf(".")));
            param.setTypeName(output.substring(in.lastIndexOf(".")));
            param.setArray(isArray);
            apiimType.getParams().add(param);
        }
        for (String throwStr : throwsList) {
            ExceptionType exception = new ExceptionType();
            exception.setTypeName(throwStr);
            apiimType.getExceptions().add(exception);
        }
        apiimType.setVersion(version);
        return apiimType;
    }
}
