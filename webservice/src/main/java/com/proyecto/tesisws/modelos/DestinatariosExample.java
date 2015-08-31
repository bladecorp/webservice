package com.proyecto.tesisws.modelos;

import java.util.ArrayList;
import java.util.List;

public class DestinatariosExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public DestinatariosExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("nombre is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("nombre is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("nombre =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("nombre <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("nombre >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("nombre >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("nombre <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("nombre <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("nombre like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("nombre not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("nombre in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("nombre not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("nombre between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("nombre not between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andAPaternoIsNull() {
            addCriterion("aPaterno is null");
            return (Criteria) this;
        }

        public Criteria andAPaternoIsNotNull() {
            addCriterion("aPaterno is not null");
            return (Criteria) this;
        }

        public Criteria andAPaternoEqualTo(String value) {
            addCriterion("aPaterno =", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoNotEqualTo(String value) {
            addCriterion("aPaterno <>", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoGreaterThan(String value) {
            addCriterion("aPaterno >", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoGreaterThanOrEqualTo(String value) {
            addCriterion("aPaterno >=", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoLessThan(String value) {
            addCriterion("aPaterno <", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoLessThanOrEqualTo(String value) {
            addCriterion("aPaterno <=", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoLike(String value) {
            addCriterion("aPaterno like", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoNotLike(String value) {
            addCriterion("aPaterno not like", value, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoIn(List<String> values) {
            addCriterion("aPaterno in", values, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoNotIn(List<String> values) {
            addCriterion("aPaterno not in", values, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoBetween(String value1, String value2) {
            addCriterion("aPaterno between", value1, value2, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAPaternoNotBetween(String value1, String value2) {
            addCriterion("aPaterno not between", value1, value2, "aPaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoIsNull() {
            addCriterion("aMaterno is null");
            return (Criteria) this;
        }

        public Criteria andAMaternoIsNotNull() {
            addCriterion("aMaterno is not null");
            return (Criteria) this;
        }

        public Criteria andAMaternoEqualTo(String value) {
            addCriterion("aMaterno =", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoNotEqualTo(String value) {
            addCriterion("aMaterno <>", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoGreaterThan(String value) {
            addCriterion("aMaterno >", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoGreaterThanOrEqualTo(String value) {
            addCriterion("aMaterno >=", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoLessThan(String value) {
            addCriterion("aMaterno <", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoLessThanOrEqualTo(String value) {
            addCriterion("aMaterno <=", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoLike(String value) {
            addCriterion("aMaterno like", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoNotLike(String value) {
            addCriterion("aMaterno not like", value, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoIn(List<String> values) {
            addCriterion("aMaterno in", values, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoNotIn(List<String> values) {
            addCriterion("aMaterno not in", values, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoBetween(String value1, String value2) {
            addCriterion("aMaterno between", value1, value2, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andAMaternoNotBetween(String value1, String value2) {
            addCriterion("aMaterno not between", value1, value2, "aMaterno");
            return (Criteria) this;
        }

        public Criteria andTelefonoIsNull() {
            addCriterion("telefono is null");
            return (Criteria) this;
        }

        public Criteria andTelefonoIsNotNull() {
            addCriterion("telefono is not null");
            return (Criteria) this;
        }

        public Criteria andTelefonoEqualTo(String value) {
            addCriterion("telefono =", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotEqualTo(String value) {
            addCriterion("telefono <>", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThan(String value) {
            addCriterion("telefono >", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThanOrEqualTo(String value) {
            addCriterion("telefono >=", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThan(String value) {
            addCriterion("telefono <", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThanOrEqualTo(String value) {
            addCriterion("telefono <=", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLike(String value) {
            addCriterion("telefono like", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotLike(String value) {
            addCriterion("telefono not like", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoIn(List<String> values) {
            addCriterion("telefono in", values, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotIn(List<String> values) {
            addCriterion("telefono not in", values, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoBetween(String value1, String value2) {
            addCriterion("telefono between", value1, value2, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotBetween(String value1, String value2) {
            addCriterion("telefono not between", value1, value2, "telefono");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionIsNull() {
            addCriterion("statusInvitacion is null");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionIsNotNull() {
            addCriterion("statusInvitacion is not null");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionEqualTo(Integer value) {
            addCriterion("statusInvitacion =", value, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionNotEqualTo(Integer value) {
            addCriterion("statusInvitacion <>", value, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionGreaterThan(Integer value) {
            addCriterion("statusInvitacion >", value, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("statusInvitacion >=", value, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionLessThan(Integer value) {
            addCriterion("statusInvitacion <", value, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionLessThanOrEqualTo(Integer value) {
            addCriterion("statusInvitacion <=", value, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionIn(List<Integer> values) {
            addCriterion("statusInvitacion in", values, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionNotIn(List<Integer> values) {
            addCriterion("statusInvitacion not in", values, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionBetween(Integer value1, Integer value2) {
            addCriterion("statusInvitacion between", value1, value2, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andStatusInvitacionNotBetween(Integer value1, Integer value2) {
            addCriterion("statusInvitacion not between", value1, value2, "statusInvitacion");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoIsNull() {
            addCriterion("idVehiculo is null");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoIsNotNull() {
            addCriterion("idVehiculo is not null");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoEqualTo(Integer value) {
            addCriterion("idVehiculo =", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoNotEqualTo(Integer value) {
            addCriterion("idVehiculo <>", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoGreaterThan(Integer value) {
            addCriterion("idVehiculo >", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idVehiculo >=", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoLessThan(Integer value) {
            addCriterion("idVehiculo <", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoLessThanOrEqualTo(Integer value) {
            addCriterion("idVehiculo <=", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoIn(List<Integer> values) {
            addCriterion("idVehiculo in", values, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoNotIn(List<Integer> values) {
            addCriterion("idVehiculo not in", values, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoBetween(Integer value1, Integer value2) {
            addCriterion("idVehiculo between", value1, value2, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoNotBetween(Integer value1, Integer value2) {
            addCriterion("idVehiculo not between", value1, value2, "idVehiculo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table destinatarios
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 18 13:15:36 CDT 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table destinatarios
     *
     * @mbggenerated Tue Aug 18 13:15:36 CDT 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}