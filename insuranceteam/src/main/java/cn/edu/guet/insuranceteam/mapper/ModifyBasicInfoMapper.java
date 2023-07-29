package cn.edu.guet.insuranceteam.mapper;

import cn.edu.guet.insuranceteam.bean.ModifyBasicInfo;
import cn.edu.guet.insuranceteam.bean.ModifyListSummaryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 罗云之
* @description 针对表【modify_basic_info】的数据库操作Mapper
* @createDate 2023-07-23 01:46:11
* @Entity cn.edu.guet.insuranceteam.bean.ModifyBasicInfo
*/
@Mapper
public interface ModifyBasicInfoMapper extends BaseMapper<ModifyBasicInfo> {

    List<ModifyListSummaryVo> getModifyListSummary(String year,String timeType);
    ModifyListSummaryVo getModifyListSummaryTotal(String year,String timeType);
}




