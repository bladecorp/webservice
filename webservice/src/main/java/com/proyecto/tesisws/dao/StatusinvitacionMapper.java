package com.proyecto.tesisws.dao;

import com.proyecto.tesisws.modelos.Statusinvitacion;
import com.proyecto.tesisws.modelos.StatusinvitacionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusinvitacionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int countByExample(StatusinvitacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int deleteByExample(StatusinvitacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int insert(Statusinvitacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int insertSelective(Statusinvitacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    List<Statusinvitacion> selectByExample(StatusinvitacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    Statusinvitacion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int updateByExampleSelective(@Param("record") Statusinvitacion record, @Param("example") StatusinvitacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int updateByExample(@Param("record") Statusinvitacion record, @Param("example") StatusinvitacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int updateByPrimaryKeySelective(Statusinvitacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table statusinvitacion
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    int updateByPrimaryKey(Statusinvitacion record);
}