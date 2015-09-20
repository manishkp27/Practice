/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wns.ta.util;

import com.wns.ta.vo.WorkItemVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u162914
 */
public class ApplicationUtil {
    
    public static List<WorkItemVO> populateJESearch(ResultSet rs) throws SQLException {
        List<WorkItemVO> list = new ArrayList<WorkItemVO>();
        WorkItemVO vo;

        while (rs.next()) {
            vo = new WorkItemVO();
            vo.setWorkItemName(ConvertUtil.convertNullToString(rs.getString("wi_name")));
            vo.setRequestorEmailAddress(ConvertUtil.convertNullToString(rs.getString("requestor_email_id")));
            vo.setRequestorName(ConvertUtil.convertNullToString(rs.getString("requestor_name")));
            vo.setApc(ConvertUtil.convertNullToString(rs.getString("apc")));
            vo.setSourceCode(ConvertUtil.convertNullToString(rs.getString("source_code")));
            vo.setCpa(ConvertUtil.convertNullToString(rs.getString("cpa")));
            vo.setDrCr(ConvertUtil.convertNullToString(rs.getString("Reminder_day1")));
            vo.setReasonCode(ConvertUtil.convertNullToString(rs.getString("reason_codes")));
            vo.setType(ConvertUtil.convertNullToString(rs.getString("type")));
            vo.setEffectiveGLDate(ConvertUtil.convertToUIDate(rs.getString("eff_gl_date"), "mm/dd/yyyy"));
            vo.setApproverEmailAddress(ConvertUtil.convertNullToString(rs.getString("approver_email_id")));
            vo.setApproverName(ConvertUtil.convertNullToString(rs.getString("approver_name")));
            
            list.add(vo);
        }

        return list;

    }
    ///////////////
    public static List<WorkItemVO> populateGLSearch(ResultSet rs) throws SQLException {
        List<WorkItemVO> list = new ArrayList<WorkItemVO>();
        WorkItemVO vo;

        while (rs.next()) {
            vo = new WorkItemVO();
            vo.setWorkItemName(ConvertUtil.convertNullToString(rs.getString("wi_name")));
            vo.setRequestorEmailAddress(ConvertUtil.convertNullToString(rs.getString("requestor_email_id")));
            vo.setRequestorName(ConvertUtil.convertNullToString(rs.getString("requestor_name")));
            vo.setApc(ConvertUtil.convertNullToString(rs.getString("apc")));
            vo.setSourceCode(ConvertUtil.convertNullToString(rs.getString("source_code")));
            vo.setCpa(ConvertUtil.convertNullToString(rs.getString("cpa")));
            vo.setReasonCode(ConvertUtil.convertNullToString(rs.getString("reason_codes")));
            vo.setType(ConvertUtil.convertNullToString(rs.getString("type")));
            vo.setEffectiveGLDate(ConvertUtil.convertToUIDate(rs.getString("eff_gl_date"), "mm/dd/yyyy"));
            vo.setApproverEmailAddress(ConvertUtil.convertNullToString(rs.getString("approver_email_id")));
            vo.setApproverName(ConvertUtil.convertNullToString(rs.getString("approver_name")));
            
            list.add(vo);
        }

        return list;

    }
    
    //////////////
    public static List<String> populateAutoComplete(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        
        while (rs.next()) {
            list.add(ConvertUtil.convertNullToString(rs.getString("requestor_email_id")));
        }
        //System.out.println("RequestorListSize=>"+list.size());
        return list;

    }
    public static List<String> populateApprEmAutoComplete(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        
        while (rs.next()) {
            list.add(ConvertUtil.convertNullToString(rs.getString("Approver1_emailid")));
        }
        //System.out.println("ApprListSize=>"+list.size());
        return list;
    }
    public static List<String> populateApcAutoComplete(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        
        while (rs.next()) {
            list.add(ConvertUtil.convertNullToString(rs.getString("APC")));
        }
        //System.out.println("APCListSize=>"+list.size());
        return list;
    }
    public static List<String> populateSourceCodeAutoComplete(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        
        while (rs.next()) {
            list.add(ConvertUtil.convertNullToString(rs.getString("Source_Code")));
        }
        //System.out.println("Source_CodeListSize=>"+list.size());
        return list;
    }
    public static List<String> populateReasonCode(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        
        while (rs.next()) {
            list.add(ConvertUtil.convertNullToString(rs.getString("Reason_Codes")));
        }
        //System.out.println("Reason_CodesListSize=>"+list.size());
        return list;
    }
    public static List<String> populateType(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        
        while (rs.next()) {
            list.add(ConvertUtil.convertNullToString(rs.getString("Type")));
        }
        //System.out.println("TypeListSize=>"+list.size());
        return list;
    }
}
