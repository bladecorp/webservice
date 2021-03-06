package com.proyecto.tesisws.dao;

import com.proyecto.tesisws.modelos.Tipostatus;
import com.proyecto.tesisws.modelos.TipostatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TipostatusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int countByExample(TipostatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int deleteByExample(TipostatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int insert(Tipostatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int insertSelective(Tipostatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    List<Tipostatus> selectByExample(TipostatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    Tipostatus selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByExampleSelective(@Param("record") Tipostatus record, @Param("example") TipostatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByExample(@Param("record") Tipostatus record, @Param("example") TipostatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByPrimaryKeySelective(Tipostatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipostatus
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByPrimaryKey(Tipostatus record);
}