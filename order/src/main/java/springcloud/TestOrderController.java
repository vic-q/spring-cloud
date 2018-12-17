package springcloud;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;

/**
 * @author wangqing
 */
@RestController
public class TestOrderController {

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    @ApiOperation(value = "我的测试", response = ResultVO.class, notes = "我的测试接口")
    public ResultVO result(@Valid @RequestBody ResultVO paras, BindingResult result) {
        return paras;
    }

}
