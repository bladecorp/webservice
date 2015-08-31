package com.proyecto.tesisws.dao;

import com.proyecto.tesisws.modelos.Historicomensajes;
import com.proyecto.tesisws.modelos.HistoricomensajesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoricomensajesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int countByExample(HistoricomensajesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int deleteByExample(HistoricomensajesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int insert(Historicomensajes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int insertSelective(Historicomensajes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    List<Historicomensajes> selectByExample(HistoricomensajesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    Historicomensajes selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int updateByExampleSelective(@Param("record") Historicomensajes record, @Param("example") HistoricomensajesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int updateByExample(@Param("record") Historicomensajes record, @Param("example") HistoricomensajesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int updateByPrimaryKeySelective(Historicomensajes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historicomensajes
     *
     * @mbggenerated Thu Aug 20 18:16:58 CDT 2015
     */
    int updateByPrimaryKey(Historicomensajes record);
}