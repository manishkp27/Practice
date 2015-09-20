<%-- 
    Document   : Search
    Created on : Dec 16, 2014, 12:42:20 PM
    Author     : u162914
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
      <meta http-equiv="x-ua-compatible" content="IE=8" >
          
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.wns.ta.dao.GAReportDAO, com.wns.ta.util.ConvertUtil" %>


<%
    List<String> requestorList = GAReportDAO.getRequestorList("JE");
    String [] requestors = requestorList.toArray(new String[requestorList.size()]);
    
    List<String> approverList = GAReportDAO.getApproverList("JE");
    String [] approvers = approverList.toArray(new String[approverList.size()]);
    
    List<String> apcList = GAReportDAO.getApc("JE");
    String [] apcs = apcList.toArray(new String[apcList.size()]); 
    
    List<String> srcList = GAReportDAO.getSourceCodeList();
    String [] sourceCodes = srcList.toArray(new String[srcList.size()]);
    
    List<String> reasonList = GAReportDAO.getReasonCodeList("JE");
    String [] reasonCodes = reasonList.toArray(new String[reasonList.size()]);
    
     List<String> typeList = GAReportDAO.getTypeList("JE");
    String [] types = typeList.toArray(new String[typeList.size()]);
   %>
 
 <script type="text/javascript">
      var requestorsArr = <%= ConvertUtil.toJavascriptArray(requestors) %>;
      var approversArr = <%= ConvertUtil.toJavascriptArray(approvers) %>;
      var apcsArr = <%= ConvertUtil.toJavascriptArray(apcs) %>;
      var srcArrAll = <%= ConvertUtil.toJavascriptArray(sourceCodes) %>;
      var reasonArr = <%= ConvertUtil.toJavascriptArray(reasonCodes) %>;
      var typeArr = <%= ConvertUtil.toJavascriptArray(types) %>;
  </script>

<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Journal Entry Approved WorkItems List</title>

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
            
            //Source code populate
            /*function ApcChanged()
            {
                var x = document.getElementById("select_Src");
                var option;
                var i= 0;
                while(i<srcArrAll.length)
                {   option = document.createElement("option");
                    option.text = srcArrAll[i];
                    //x.add(option,x[0]); 
                    x.add(option); 
                    
                    i++;
                }
            }*/
            
         $(document).ready(function() 
         {
            //Source code populate 
            var x = document.getElementById("select_Src");
                var option;
                var i= 0;
                while(i<srcArrAll.length)
                {   option = document.createElement("option");
                    option.text = srcArrAll[i];
                    //x.add(option,x[0]); 
                    x.add(option); 
                    
                    i++;
                } 
             
            //reason code populate
            var x = document.getElementById("select_ReasonCode");
                var option;
                var i= 0;
                while(i<srcArrAll.length)
                {   option = document.createElement("option");
                    option.text = reasonArr[i];
                    x.add(option); 
                    
                    i++;
                }
                option=0;
                
            // Type populate
            var x2 = document.getElementById("select_Type");
                var option2;
                var i= 0;
                //alert("type length="+srcArrAll.length);
                while(i<typeArr.length)
                {   option2 = document.createElement("option");
                    option2.text = typeArr[i];
                    
                    x2.add(option2); 
                    
                    i++;
                }
               
            //Date selection
            $(function() {    
                $( "#datepckEffFrom" ).datepicker(); 
            });
            $(function() {    
                $( "#datepckEffTo" ).datepicker(); 
            });
            $(function() {    
                $( "#approvalFrom" ).datepicker(); 
            });
            $(function() {    
                $( "#approvalTo" ).datepicker(); 
            });   
               
            $('#txt_Src').click(function()           
             {
                //alert("querySourceCode()");
             });
             
            $('#btn_search').click(function()           
              {                  
                var WI_Name = $('#txt_WI_Name').val();
                var requestorEmail = $('#txt_requestors').val();
                var txt_APC = $('#txt_APC').val();
                var select_Src = $('#select_Src').val();
                var select_Cpa = $('#select_Cpa').val();
                var select_ReasonCode = $('#select_ReasonCode').val();
                var select_Type = $('#select_Type').val();
                var datepckEffFrom = $('#datepckEffFrom').val();
                var datepckEffTo = $('#datepckEffTo').val();
                var approvalFrom = $('#approvalFrom').val();
                var approvalTo = $('#approvalTo').val();
                var approverEmail = $('#txt_approvers').val();
                
                //alert("txt_WI_Name:"+WI_Name+ ", requestorEmail"+requestorEmail+", approverEmail:"+approverEmail );
                
                var url = "../../JESearchController?action=search1"
                            +"&WI_Name="+WI_Name+"&requestorEmail="+requestorEmail
                            + "&txt_APC="+txt_APC + "&select_Src="+select_Src
                            +"&select_Cpa="+select_Cpa + "&select_ReasonCode="+select_ReasonCode + "&select_Type="+select_Type
                            +"&datepckEffFrom="+datepckEffFrom + "&datepckEffTo="+datepckEffTo + "&approvalFrom="+approvalFrom
                            +"&approvalTo="+approvalTo +"&approverEmail="+approverEmail 
                            +"&"+Math.floor((Math.random()*100)+1);
                            
                $('#WITableContainer').jtable({
                    cache:false,
                    title: 'Journal Entry Approved WorkItems List',
                    actions: {
                        listAction: url
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
                        
                         drCr: {
                            title: 'Dr/Cr',
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
                $('#WITableContainer').jtable('reload');
               //alert('search end');
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
        });
        </script>

    </head>
    <body>
        <table>
            <tr>
                <td>
                    WorkItem Name: <input type='text' style='font-family:verdana;width:200px;font-size:12px' id='txt_WI_Name' value=''/> 
                </td>
                <td>
                    Requestor: <input type='text' style='font-family:verdana;width:200px;font-size:12px' id='txt_requestors' value=''/> 
                </td>
                
                <td>
                    APC: <input type='text' style='font-family:verdana;width:200px;font-size:12px' id='txt_APC' value='' onchange="ApcChanged();"/> 
                </td>
                <td>
                    Source: <select style='font-family:verdana;width:200px;font-size:12px' id='select_Src' >
                        <option value="">-Select-</option>
                    </select>
                </td>
                
            </tr>    
            <tr>  
                <td>
                    CPA: <select style='font-family:verdana;width:200px;font-size:12px' id='select_Cpa' >
                        <option value="">Y</option>
                        <option value="">N</option>
                    </select>
                </td>
                <td>
                    Reason Code: <select style='font-family:verdana;width:200px;font-size:12px' id='select_ReasonCode' >
                        <option value="">-Select-</option>
                    </select>
                </td>
                <td>
                    Type: <select style='font-family:verdana;width:200px;font-size:12px' id='select_Type' >
                        <option value="">-Select-</option>
                    </select>
                </td>
             </tr>
             <tr>    
                <td>
                    Eff. GL Date: From <input type="text" id="datepckEffFrom" value=""/>
                </td>                
                <td>
                    Eff. GL Date: To <input type="text" id="datepckEffTo" value=""/>
                </td>
                <td>
                   Approval Date: From <input type="text" id="approvalFrom" value=""/>
                </td>                
                <td>
                   Approval Date: To <input type="text" id="approvalTo" value=""/>
                </td>
             </tr>
             <tr>  
                <td>
                    Approver: <input type='text' style='font-family:verdana;width:200px;font-size:12px' id='txt_approvers' value=''/> 
                </td>
                
                <td>
                    <input type='button' style='font-family:verdana;width:200px;font-size:12px' id='btn_search' value="Search" /> 
                </td>
            </tr>
        </table>

                <script>
                    var obj1 = new actb(document.getElementById('txt_requestors'),requestorsArr);
                    var obj2 = new actb(document.getElementById('txt_approvers'),approversArr);
                    var obj3 = actb(document.getElementById('txt_APC'),apcsArr);
                 </script>

            
        <br><br>

        <div style="text-align: center;">
            <div id="WITableContainer"></div>
        </div> 
    </body>
</html>
