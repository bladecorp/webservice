package com.proyecto.tesisws.modelos;

import java.util.ArrayList;
import java.util.List;

public class VehiculosExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public VehiculosExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
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
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
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

        public Criteria andPlacasIsNull() {
            addCriterion("placas is null");
            return (Criteria) this;
        }

        public Criteria andPlacasIsNotNull() {
            addCriterion("placas is not null");
            return (Criteria) this;
        }

        public Criteria andPlacasEqualTo(String value) {
            addCriterion("placas =", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasNotEqualTo(String value) {
            addCriterion("placas <>", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasGreaterThan(String value) {
            addCriterion("placas >", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasGreaterThanOrEqualTo(String value) {
            addCriterion("placas >=", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasLessThan(String value) {
            addCriterion("placas <", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasLessThanOrEqualTo(String value) {
            addCriterion("placas <=", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasLike(String value) {
            addCriterion("placas like", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasNotLike(String value) {
            addCriterion("placas not like", value, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasIn(List<String> values) {
            addCriterion("placas in", values, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasNotIn(List<String> values) {
            addCriterion("placas not in", values, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasBetween(String value1, String value2) {
            addCriterion("placas between", value1, value2, "placas");
            return (Criteria) this;
        }

        public Criteria andPlacasNotBetween(String value1, String value2) {
            addCriterion("placas not between", value1, value2, "placas");
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

        public Criteria andIdUsuarioIsNull() {
            addCriterion("idUsuario is null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIsNotNull() {
            addCriterion("idUsuario is not null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioEqualTo(Integer value) {
            addCriterion("idUsuario =", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotEqualTo(Integer value) {
            addCriterion("idUsuario <>", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThan(Integer value) {
            addCriterion("idUsuario >", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("idUsuario >=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThan(Integer value) {
            addCriterion("idUsuario <", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThanOrEqualTo(Integer value) {
            addCriterion("idUsuario <=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIn(List<Integer> values) {
            addCriterion("idUsuario in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotIn(List<Integer> values) {
            addCriterion("idUsuario not in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioBetween(Integer value1, Integer value2) {
            addCriterion("idUsuario between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("idUsuario not between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoIsNull() {
            addCriterion("idTipoVehiculo is null");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoIsNotNull() {
            addCriterion("idTipoVehiculo is not null");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoEqualTo(Integer value) {
            addCriterion("idTipoVehiculo =", value, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoNotEqualTo(Integer value) {
            addCriterion("idTipoVehiculo <>", value, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoGreaterThan(Integer value) {
            addCriterion("idTipoVehiculo >", value, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idTipoVehiculo >=", value, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoLessThan(Integer value) {
            addCriterion("idTipoVehiculo <", value, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoLessThanOrEqualTo(Integer value) {
            addCriterion("idTipoVehiculo <=", value, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoIn(List<Integer> values) {
            addCriterion("idTipoVehiculo in", values, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoNotIn(List<Integer> values) {
            addCriterion("idTipoVehiculo not in", values, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoBetween(Integer value1, Integer value2) {
            addCriterion("idTipoVehiculo between", value1, value2, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoVehiculoNotBetween(Integer value1, Integer value2) {
            addCriterion("idTipoVehiculo not between", value1, value2, "idTipoVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusIsNull() {
            addCriterion("idTipoStatus is null");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusIsNotNull() {
            addCriterion("idTipoStatus is not null");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusEqualTo(Integer value) {
            addCriterion("idTipoStatus =", value, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusNotEqualTo(Integer value) {
            addCriterion("idTipoStatus <>", value, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusGreaterThan(Integer value) {
            addCriterion("idTipoStatus >", value, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("idTipoStatus >=", value, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusLessThan(Integer value) {
            addCriterion("idTipoStatus <", value, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("idTipoStatus <=", value, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusIn(List<Integer> values) {
            addCriterion("idTipoStatus in", values, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusNotIn(List<Integer> values) {
            addCriterion("idTipoStatus not in", values, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusBetween(Integer value1, Integer value2) {
            addCriterion("idTipoStatus between", value1, value2, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdTipoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("idTipoStatus not between", value1, value2, "idTipoStatus");
            return (Criteria) this;
        }

        public Criteria andIdModeloIsNull() {
            addCriterion("idModelo is null");
            return (Criteria) this;
        }

        public Criteria andIdModeloIsNotNull() {
            addCriterion("idModelo is not null");
            return (Criteria) this;
        }

        public Criteria andIdModeloEqualTo(Integer value) {
            addCriterion("idModelo =", value, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloNotEqualTo(Integer value) {
            addCriterion("idModelo <>", value, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloGreaterThan(Integer value) {
            addCriterion("idModelo >", value, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloGreaterThanOrEqualTo(Integer value) {
            addCriterion("idModelo >=", value, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloLessThan(Integer value) {
            addCriterion("idModelo <", value, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloLessThanOrEqualTo(Integer value) {
            addCriterion("idModelo <=", value, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloIn(List<Integer> values) {
            addCriterion("idModelo in", values, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloNotIn(List<Integer> values) {
            addCriterion("idModelo not in", values, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloBetween(Integer value1, Integer value2) {
            addCriterion("idModelo between", value1, value2, "idModelo");
            return (Criteria) this;
        }

        public Criteria andIdModeloNotBetween(Integer value1, Integer value2) {
            addCriterion("idModelo not between", value1, value2, "idModelo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vehiculos
     *
     * @mbggenerated do_not_delete_during_merge Sat Aug 01 13:17:37 CDT 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vehiculos
     *
     * @mbggenerated Sat Aug 01 13:17:37 CDT 2015
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