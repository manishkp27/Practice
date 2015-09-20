/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wns.ta.dao;

import com.wns.ta.db.SQLServerConnection;
import com.wns.ta.util.ApplicationUtil;
import com.wns.ta.vo.WorkItemVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author u162914
 */
public class GAReportDAO {
    
    public static List<WorkItemVO> generateJESearch1(String WI_Name,String requestorEmail,            
                        String txt_APC, String select_Src,String select_Cpa,
                        String select_ReasonCode,String select_Type,String datepckEffFrom,
                        String datepckEffTo,String approverEmail,String approvalFrom,String approvalTo
            ) 
    {
        System.out.println("generateJESearch1() start");
        
        List<WorkItemVO> list = null;
        Connection conn = null;
        CallableStatement cs = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        //String query;

        try {

            conn = SQLServerConnection.getConnection();

            cs = conn.prepareCall("exec WNS_TA_GA_JE_Search_Form ?,?,?,?,?,?,?,?,?,?,?,?");
            cs.setString(1, WI_Name);
            cs.setString(2, requestorEmail);
            cs.setString(3, txt_APC);
            cs.setString(4, select_Src);
            cs.setString(5, select_Cpa);
            cs.setString(6, select_ReasonCode);
            cs.setString(7, select_Type);
            cs.setString(8, datepckEffFrom);
            cs.setString(9, datepckEffTo);
            cs.setString(10, approverEmail);
            cs.setString(11, approvalFrom);
            cs.setString(12, approvalTo);
            
            cs.executeQuery();
            ResultSet rs1 = cs.getResultSet();
            list = ApplicationUtil.populateJESearch(rs1);
            
            System.out.println("generateJESearch1() end list size:"+list.size());            

        } catch (SQLException ex) {
            System.out.println("generateJESearch1()Exception ex:"+ex);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                // logger.error(new Date() + " :: " + "ReportDAO.java" + " :: " + ex.toString(), ex);
            }
        }

        return list;
    }
    public static List<WorkItemVO> generateJESearch() {

        List<WorkItemVO> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = SQLServerConnection.getConnection();
            query = "Select  wi_name, requestor_email_id, requestor_name, apc, source_code, "
                    + "cpa, reason_codes, TYPE, eff_gl_date, '' approver_email_id, "
                    + "'' approver_name "
                    + "from WNS_TA_GA_EXT_Table "
                    + "where introduction_type = 'JE' and finalapprovaldecision = 'Approved'"
                    + "order by WI_Name";

            prepStmt = conn.prepareStatement(query);
            /*prepStmt.setString(1, reportSearchVO.getStatus());
            prepStmt.setString(2, reportSearchVO.getStatus());
            prepStmt.setString(3, reportSearchVO.getStatus());
            prepStmt.setString(4, reportSearchVO.getStatus());
            prepStmt.setString(5, reportSearchVO.getStatus());
            prepStmt.setString(6, reportSearchVO.getFrom_date());
            prepStmt.setString(7, reportSearchVO.getFrom_date());
            prepStmt.setString(8, reportSearchVO.getTo_date());
            prepStmt.setString(9, reportSearchVO.getTo_date());
            prepStmt.setString(10, "%" + reportSearchVO.getBatch_name() + "%"); */
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateJESearch(rs);

        } catch (SQLException ex) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                // logger.error(new Date() + " :: " + "ReportDAO.java" + " :: " + ex.toString(), ex);
            }
        }

        return list;
    }
    ////////////////////////////////////////
    public static List<WorkItemVO> generateGLSearch() {

        List<WorkItemVO> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = SQLServerConnection.getConnection();
            query = "Select  wi_name, requestor_email_id, requestor_name, apc, source_code, "
                    + "cpa, reason_codes, TYPE, eff_gl_date, '' approver_email_id, "
                    + "'' approver_name "
                    + "from WNS_TA_GA_EXT_Table "
                    + "where introduction_type = 'GL' and finalapprovaldecision = 'Approved'"
                    + "order by WI_Name";

            prepStmt = conn.prepareStatement(query);
            /*prepStmt.setString(1, reportSearchVO.getStatus());
            prepStmt.setString(2, reportSearchVO.getStatus());
            prepStmt.setString(3, reportSearchVO.getStatus());
            prepStmt.setString(4, reportSearchVO.getStatus());
            prepStmt.setString(5, reportSearchVO.getStatus());
            prepStmt.setString(6, reportSearchVO.getFrom_date());
            prepStmt.setString(7, reportSearchVO.getFrom_date());
            prepStmt.setString(8, reportSearchVO.getTo_date());
            prepStmt.setString(9, reportSearchVO.getTo_date());
            prepStmt.setString(10, "%" + reportSearchVO.getBatch_name() + "%"); */
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateGLSearch(rs);

        } catch (SQLException ex) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<String> getRequestorList(String reportType) {

        List<String> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = SQLServerConnection.getConnection();
            query = "Select distinct requestor_email_id from WNS_TA_GA_EXT_Table WITH (NOLOCK) "
                    + "where introduction_type = ? "
                    + "order by requestor_email_id";
             //System.out.println("query=>"+query);
             
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, reportType);
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateAutoComplete(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    }
    /////////////////////////////////////////////////////////////////////////////
     ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<String> getApproverList(String reportType) {

        List<String> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = SQLServerConnection.getConnection();
            query = "Select distinct Approver1_emailid from WNS_TA_GA_EXT_Table WITH (NOLOCK) "
                    + "where introduction_type = ? and Approver1_emailid is not null "
                    + "order by Approver1_emailid";
            //System.out.println("query=>"+query);
            
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, reportType);
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateApprEmAutoComplete(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    }
    public static List<String> getApc(String reportType) {

        List<String> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = SQLServerConnection.getConnection();
            query = "Select distinct APC from WNS_TA_GA_EXT_Table WITH (NOLOCK) "
                    + "where introduction_type = ? "
                    + "order by APC";
            //System.out.println("query=>"+query);
            
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, reportType);
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateApcAutoComplete(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    }
    
    
    public static List<String> getSourceCodeList() {

        List<String> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = SQLServerConnection.getConnection();
            query = " Select distinct substring (Source_Code,0,4) as Source_Code from WNS_TA_GA_EXT_Table WITH (NOLOCK) "
                    + " where introduction_type = 'JE' and Source_Code is not NULL";
            
           //System.out.println("query=>"+query);
            
            prepStmt = conn.prepareStatement(query);
            //prepStmt.setString(1, apcCode);
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateSourceCodeAutoComplete(rs);
            //System.out.println("list.size==>"+list.size());
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    }    
    
    public static List<String> getReasonCodeList(String reportType) {

        List<String> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;
        //System.out.println("getReasonCodeList()");
        
        try {

            conn = SQLServerConnection.getConnection();
            query = " Select distinct Reason_Codes from WNS_TA_GA_EXT_Table WITH (NOLOCK)  "
                    + " where introduction_type = ? and Reason_Codes is not NULL ";
            
            //System.out.println("query=>"+query);
            
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, reportType);
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateReasonCode(rs);
            //System.out.println("list.size==>"+list.size());
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    } 
    public static List<String> getTypeList(String reportType) {

        List<String> list = null;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String query;
        //System.out.println("getTypeList()");
        
        try {

            conn = SQLServerConnection.getConnection();
            query = " Select distinct Type from WNS_TA_GA_EXT_Table WITH (NOLOCK)  "
                    + " where introduction_type = ? and Type is not NULL ";
            
            //System.out.println("query=>"+query);
            
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, reportType);
            rs = prepStmt.executeQuery();
            list = ApplicationUtil.populateType(rs);
            //System.out.println("list.size==>"+list.size());
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return list;
    } 
}
