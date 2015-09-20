<%-- 
    Document   : Search
    Created on : Dec 16, 2014, 12:42:20 PM
    Author     : u162914
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.wns.ta.dao.GAReportDAO, com.wns.ta.util.ConvertUtil" %>
<!DOCTYPE html>

<%
    List<String> requestorList = GAReportDAO.getRequestorList("GL");
    
    String [] requestors = requestorList.toArray(new String[requestorList.size()]);
    
    List<String> approverList = GAReportDAO.getApproverList("GL");
    String [] approvers = approverList.toArray(new String[approverList.size()]);
    
    
    
 %>
 
 <script type="text/javascript">
      var requestorsArr = <%= ConvertUtil.toJavascriptArray(requestors) %>;
      var approversArr = <%= ConvertUtil.toJavascriptArray(approvers) %>;
      
      
  </script>
     
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GL Maintenance Approved WorkItems List</title>

        <!-- Styles. -->
        <link href="../../assets/css/jtable.css" rel="stylesheet" type="text/css" />
        <link href="../../assets/css/jquery-ui.css" rel="stylesheet" type="text/css" />


        <!-- Script file. -->
        <script src="../../assets/js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="../../assets/js/jquery-ui.js" type="text/javascript"></script>
        <script src="../../assets/js/jquery.jtable.js" type="text/javascript"></script>
        <script src="../../assets/js/actb.js" type="text/javascript"></script>
        <script src="../../assets/js/common.js" type="text/javascript"></script>
        
        

        <script type="text/javascript">
           
            
            $(document).ready(function() {
                $('#WITableContainer').jtable({
                    title: 'GL Maintenance Approved WorkItems List',
                    actions: {
                        listAction: '../../JESearchController?action=search'
                    },
                    fields: {
                        workItemName: {
                            title: 'WorkItem Name',
                            width: '10%',
                            key: true,
                            list: true,
                            create: true
                        },
                        requestorEmailAddress: {
                            title: 'Req. Email',
                            width: '8%',
                            key: true,
                            list: true,
                            create: true
                        },
                        requestorName: {
                            title: 'Req. Name',
                            width: '7%',
                            key: true,
                            list: true,
                            create: true
                        },
                        apc: {
                            title: 'APC',
                            width: '5%',
                            key: true,
                            list: true,
                            create: true
                        },
                        sourceCode: {
                            title: 'Source Code',
                            width: '10%',
                            key: true,
                            list: true,
                            create: true
                        },
                        cpa: {
                            title: 'CPA',
                            width: '5%',
                            key: true,
                            list: true,
                            create: true
                        },
                        reasonCode: {
                            title: 'Reason Code',
                            width: '10%',
                            key: true,
                            list: true,
                            create: true
                        },
                        type: {
                            title: 'Type',
                            width: '5%',
                            key: true,
                            list: true,
                            create: true
                        },
                        effectiveGLDate: {
                            title: 'Eff. GL Date',
                            width: '10%',
                            key: true,
                            list: true,
                            create: true
                        },
                        approverEmailAddress: {
                            title: 'Appr. Email',
                            width: '9%',
                            key: true,
                            list: true,
                            create: true
                        },
                        approverName: {
                            title: 'Appr. Name',
                            width: '9%',
                            key: true,
                            list: true,
                            create: true
                        }

                    }
                });
                $('#WITableContainer').jtable('load');
            });


            //////////////////////////////////
            // Do not delete this commented method ////
           /* $(document).ready(function() {
                $(function() {
                    $("#search").autocomplete({
                        source: function(request, response) {
                            $.ajax({
                                url: "../../JESearchController?action=requestorlist",
                                type: "GET",
                                data: {
                                    requestor: request.term
                                },
                                dataType: "json",
                                success: function(data) {
                                    response(data);
                                }
                            });
                        }
                    });
                });
            }); */

        </script>









    </head>
    <body>
        <table>
            <tr>
                <td>
                    Requestor: <input type='text' style='font-family:verdana;width:200px;font-size:12px' id='txt_requestors' value=''/> 
                </td>
                <td>
                    Approver: <input type='text' style='font-family:verdana;width:200px;font-size:12px' id='txt_approvers' value=''/> 
                </td>
            </tr>
        </table>

                <script>
                    var obj = actb(document.getElementById('txt_requestors'),requestorsArr);
                    var obj = actb(document.getElementById('txt_approvers'),approversArr);
                 </script>

            
        <br><br>

        <div style="text-align: center;">
            <div id="WITableContainer"></div>
        </div> 
    </body>
</html>
