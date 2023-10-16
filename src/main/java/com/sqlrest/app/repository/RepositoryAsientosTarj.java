package com.sqlrest.app.repository;

import com.sqlrest.app.request.RequestAsientosTarj;
import com.sqlrest.app.response.ResponseAsientosTarj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryAsientosTarj {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ResponseAsientosTarj
    executeProcedure(RequestAsientosTarj request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
                .withProcedureName("sp_genera_asiento_tarjeta_conti")
                .declareParameters(
                        new SqlParameter("pi_cta", Types.VARCHAR),
                        new SqlParameter("pi_monto", Types.FLOAT),
                        new SqlParameter("pi_moneda", Types.VARCHAR),
                        new SqlParameter("pi_concepto", Types.VARCHAR),
                        new SqlParameter("pi_descr_as", Types.VARCHAR),
                        new SqlOutParameter("po_codpro", Types.INTEGER),
                        new SqlOutParameter("po_operel", Types.VARCHAR),
                        new SqlOutParameter("po_astorel", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("pi_cta", request.getCta());
        inParams.put("pi_monto", request.getMonto());
        inParams.put("pi_moneda", request.getMoneda());
        inParams.put("pi_concepto", request.getConcepto());
        inParams.put("pi_descr_as", request.getDescrAs());

        Map<String, Object> outParams = jdbcCall.execute(inParams);

        ResponseAsientosTarj response = new ResponseAsientosTarj();
        response.setCodPro((int) outParams.get("po_codpro"));
        response.setOperEl((String) outParams.get("po_operel"));
        response.setAstoRel((String) outParams.get("po_astorel"));

        return response;
    }
}
