package springcloud;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangqing
 */
@ApiModel(value = "Result", description = "测试result")
public class ResultVO {

    @ApiModelProperty(value = "api名称", example = "测试api", required = true)
    @NotNull(message = "api名称不能为空")
    private String apiName;
    @ApiModelProperty(value = "api描述", example = "测试api描述", required = true)
    private String desc;
    @Max(3)
    private Integer value;

    public ResultVO() {
    }

    public ResultVO(String apiName, String desc, Integer value) {
        this.apiName = apiName;
        this.desc = desc;
        this.value = value;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
