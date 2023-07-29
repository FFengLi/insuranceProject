package cn.edu.guet.insuranceteam.service.impl;

import cn.edu.guet.insuranceteam.bean.ModifyListSummaryVo;
import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.mapper.ModifyListSummaryVoMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceteam.bean.ModifyBasicInfo;
import cn.edu.guet.insuranceteam.service.ModifyBasicInfoService;
import cn.edu.guet.insuranceteam.mapper.ModifyBasicInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author 罗云之
 * @description 针对表【modify_basic_info】的数据库操作Service实现
 * @createDate 2023-07-23 01:46:11
 */
@Service
public class ModifyBasicInfoServiceImpl extends ServiceImpl<ModifyBasicInfoMapper, ModifyBasicInfo>
        implements ModifyBasicInfoService{
    @Autowired
    private ModifyBasicInfoMapper modifyBasicInfoMapper;

    @Autowired
    private ModifyListSummaryVoMapper modifyListSummaryVoMapper;
//    @Override
//    public ResponseData<List<ModifyListSummaryVo>> getModifyListSummary(String year,String timeType) {
//        List<ModifyListSummaryVo> modifyListSummaryVoList = modifyBasicInfoMapper.getModifyListSummary(year,timeType);
//        if (!modifyListSummaryVoList.isEmpty()){
//            ModifyListSummaryVo modifyListSummaryTotal = modifyBasicInfoMapper.getModifyListSummaryTotal(year,timeType);
//            modifyListSummaryTotal.setPrefecture("合计");
//            modifyListSummaryVoList.add(modifyListSummaryTotal);
//            return ResponseData.ok(modifyListSummaryVoList);
//        }
//        return ResponseData.fail("无迁改记录");
//    }
    @Override
    public ResponseData<List<ModifyListSummaryVo>> getModifyListSummary(String year,String timeType) {
        LambdaQueryWrapper<ModifyListSummaryVo> queryWrapper1 = new QueryWrapper<ModifyListSummaryVo>()
                .select("prefecture, "
                        +"COUNT(" + timeType + ") AS changeCompensateAmount,"
                        +" SUM(MONTH(" + timeType + ") = 1) AS januaryAmount,"
                        +" SUM(MONTH(" + timeType + ") = 2) AS februaryAmount,"
                        +" SUM(MONTH(" + timeType + ") = 3) AS marchAmount,"
                        +" SUM(MONTH(" + timeType + ") = 4) AS aprilAmount,"
                        +" SUM(MONTH(" + timeType + ") = 5) AS mayAmount,"
                        +" SUM(MONTH(" + timeType + ") = 6) AS juneAmount,"
                        +" SUM(MONTH(" + timeType + ") = 7) AS julyAmount,"
                        +" SUM(MONTH(" + timeType + ") = 8) AS augustAmount,"
                        +" SUM(MONTH(" + timeType + ") = 9) AS septemberAmount,"
                        +" SUM(MONTH(" + timeType + ") = 10) AS octoberAmount,"
                        +" SUM(MONTH(" + timeType + ") = 11) AS novemberAmount,"
                        +" SUM(MONTH(" + timeType + ") = 12) AS decemberAmount,"
                        +" SUM(compensation_costs) AS totalAmount").lambda();
        queryWrapper1.groupBy(ModifyListSummaryVo::getPrefecture);
        queryWrapper1.apply("YEAR(" + timeType + ") = "+ year);
        List<ModifyListSummaryVo> modifyListSummaryVoList = modifyListSummaryVoMapper.selectList(queryWrapper1);
        if (!modifyListSummaryVoList.isEmpty()){
            LambdaQueryWrapper<ModifyListSummaryVo> queryWrapper2 = new QueryWrapper<ModifyListSummaryVo>()
                    .select("COUNT(" + timeType + ") AS changeCompensateAmount,"
                            +" SUM(MONTH(" + timeType + ") = 1) AS januaryAmount,"
                            +" SUM(MONTH(" + timeType + ") = 2) AS februaryAmount,"
                            +" SUM(MONTH(" + timeType + ") = 3) AS marchAmount,"
                            +" SUM(MONTH(" + timeType + ") = 4) AS aprilAmount,"
                            +" SUM(MONTH(" + timeType + ") = 5) AS mayAmount,"
                            +" SUM(MONTH(" + timeType + ") = 6) AS juneAmount,"
                            +" SUM(MONTH(" + timeType + ") = 7) AS julyAmount,"
                            +" SUM(MONTH(" + timeType + ") = 8) AS augustAmount,"
                            +" SUM(MONTH(" + timeType + ") = 9) AS septemberAmount,"
                            +" SUM(MONTH(" + timeType + ") = 10) AS octoberAmount,"
                            +" SUM(MONTH(" + timeType + ") = 11) AS novemberAmount,"
                            +" SUM(MONTH(" + timeType + ") = 12) AS decemberAmount,"
                            +" SUM(compensation_costs) AS totalAmount").lambda();
            queryWrapper2.apply("YEAR(" + timeType + ") = "+ year);
            ModifyListSummaryVo modifyListSummaryTotal = modifyListSummaryVoMapper.selectOne(queryWrapper2);
            modifyListSummaryTotal.setPrefecture("合计");
            modifyListSummaryVoList.add(modifyListSummaryTotal);
            return ResponseData.ok(modifyListSummaryVoList);
        }
        return ResponseData.fail("无迁改记录");
    }
}




