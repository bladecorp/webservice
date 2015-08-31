package com.proyecto.tesisws.dao;

import com.proyecto.tesisws.modelos.Marcas;
import com.proyecto.tesisws.modelos.MarcasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarcasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int countByExample(MarcasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int deleteByExample(MarcasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int insert(Marcas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int insertSelective(Marcas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    List<Marcas> selectByExample(MarcasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    Marcas selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByExampleSelective(@Param("record") Marcas record, @Param("example") MarcasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByExample(@Param("record") Marcas record, @Param("example") MarcasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByPrimaryKeySelective(Marcas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table marcas
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    int updateByPrimaryKey(Marcas record);
}