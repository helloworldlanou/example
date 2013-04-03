<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <base href="<%=basePath%>"/>
<title>国家电网公司高级培训中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<body text="#000000" bgColor="#e6e6e6" topMargin="0">
<%@ include file="head.jsp"%>

<Table cellSpacing=0 cellPadding=0 width=770 align=center border=0 bgcolor="#FFFFFF"> 
  <tr>
    <td colspan="2">
    <Table cellSpacing=0 cellPadding=0 width="100%" border=0> 
        <tr>
          <td height=1 bgcolor="#e6e6e6" class="g12">&nbsp;</td>
        </tr>
        <tr>
          <td height=2><img src="image/main/book001.gif" width="770" height="14"></td>
        </tr>
      </Table>
    </td>
  </tr>
  <tr>
    <td width="164"  valign="top" style="padding-left:3px"> 
    <Table width=160  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" ><span style="padding-left:35px"><a class="styleWhite" href="mainAction.do?action=toSecondaryPage">单位介绍</a></span>       </td>
     </tr>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
                        <tr width=160>
                          <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12    href="mainAction.do?action=toSecondaryPage" >&nbsp;单位介绍</A></td>
                        </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9   src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12      href="mainAction.do?action=toSecondaryPage" >&nbsp;单位领导</A></td>
                        </tr>
                        <tr>
                           <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12   href="mainAction.do?action=toSecondaryPage" >&nbsp;组织机构</A></td>
                        </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;企业文化</A></td>
                        </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                         <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12    href="mainAction.do?action=toSecondaryPage" >&nbsp;地理位置</A></td>
                        </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9   src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;联系方式</A></td>
                        </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
            </Table></td></tr>
      </Table>
                   
   <Table width=160  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" ><span style="padding-left:35px"><a class="styleWhite" href="mainAction.do?action=toSecondaryPage">中心新闻</a></span></td>
     </tr>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
                        <tr width=160>
                          <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;新闻中心</A></td>
                        </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        
          </Table></td></tr>
      </Table>
                    <Table width=160  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" ><span style="padding-left:35px"><a class="styleWhite" href="mainAction.do?action=toSecondaryPage">党校教育</a></span>       </td>
     </tr>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
                        <tr width=160>
                          <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;政策文件</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9   src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;教学计划</A></td>
              </tr>
                        <tr>
                           <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12   href="mainAction.do?action=toSecondaryPage" >&nbsp;理论学习</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
          </Table></td></tr>
                   </Table>
                    <Table width=160  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" ><span style="padding-left:35px"><A class=styleWhite  href="mainAction.do?action=toSecondaryPage" >培训教学</A></span>       </td>
     </tr>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
                        <tr width=160>
                          <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12      href="mainAction.do?action=toSecondaryPage" >&nbsp;培训动态</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9   src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;培训研究</A></td>
              </tr>
                        <tr>
                           <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12   href="mainAction.do?action=toSecondaryPage" >&nbsp;学员心声</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12    href="mainAction.do?action=toSecondaryPage" >&nbsp;班级风采</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        
          </Table></td></tr>
                   </Table>
                    <Table width=160  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" ><span class="red14b STYLE47" style="padding-left:35px"><A class=styleWhite href="mainAction.do?action=toSecondaryPage" >精品项目</A></span>       </td>
     </tr>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
                        <tr width=160>
                          <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12      href="mainAction.do?action=toSecondaryPage" >&nbsp;成功案例</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9   src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;项目介绍</A></td>
              </tr>
                        <tr>
                           <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12   href="mainAction.do?action=toSecondaryPage" >&nbsp;精品课程</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
          </Table></td></tr>
                   </Table>    
                
   <Table width=160  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" ><span class="red14b STYLE47" style="padding-left:35px"><A class=styleWhite href="mainAction.do?action=toSecondaryPage" >后勤服务</A></span>       </td>
     </tr>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
                        <tr width=160>
                          <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;会议服务</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9   src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;培训设施</A></td>
              </tr>
                        <tr>
                           <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12   href="mainAction.do?action=toSecondaryPage" >&nbsp;娱乐设施</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;客房服务</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                         <tr>
                          <td align=right><IMG height=9 src="image/main/arrow_021.gif" width=12></td>
                          <td height=20><A class=g12     href="mainAction.do?action=toSecondaryPage" >&nbsp;餐饮服务</A></td>
              </tr>
                        <tr>
                          <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
                        </tr>
                        
          </Table></td></tr>
      </Table>   </td>
                
                
                  
                  
    <td width="585"  valign="top" style=" padding-left:12px">
    
    
    <table width="575" border="0">
      <tr>
        <td width="575">    
    		<table cellSpacing=0 cellPadding=0 width=560 border=0> 
         		<tr>
             		 <td><IMG height=17 src="image/main/tt-011.gif" width=575></td>
       	      </tr> 
   		    </table>
   		    <table cellSpacing=0 cellPadding=0 width=575 border=0> 
                <tr>
                     <td vAlign=top width=6 height=179><IMG height=179 src="image/main/tt_02.gif" width=6></td>
                     <td vAlign=top align=middle>
                     	 <table cellSpacing=0 cellPadding=0 width="99%" border=0> 
                        	<tr>
                          		<td vAlign=top align=middle width=5> <a href="mainAction.do?action=toDetailPage" target="_blank" ><IMG height=160 src="image/main/12971.jpg"  width=200 border=0></a></td>
                         		 <td>
                         		 <table width="99%" height="151"    border=0 cellPadding=0 cellSpacing=4> 
                             	 		<tr>
                              	 			 <td align=middle><B  style="FONT-SIZE: 14px; COLOR: #000000; LINE-HEIGHT: 22px"></B></td>
                               		    </tr>
                              			 <tr>
                                			<td align=middle><B  style="FONT-SIZE: 16px; COLOR: #9c0000">刘振亚先后会见三家银行董事长   </B></td>
                               			 </tr>
                              			
                             	 		
                             			 <tr>
											 <td style="LINE-HEIGHT: 20px"  align=left>　&nbsp;&nbsp;12月23日、25日，国家电网公司党组书记、总经理刘振亚在公司总部，先后会见了来访的中国银行股份有限公司董事长肖刚一行、中国建设银行股份有限公司董事长郭树清一行以及中国工商银行股份有限公司董事长姜建清一行。各方就贷款支持、授信担保、债券承销、代收电费等业务......  </td>
                             			 </tr>
                             	</table>                            	</td>
                            </tr>
                       </table>                         </td>
                    <td vAlign=top width=6><IMG height=179  src="image/main/tt_02.gif" width=6></td>
              </tr> 
          </table>                 </td>
      </tr>
      <tr>
        <td>
        
        
<table width="585" border="0">
  <tr>
    <td width="387" valign="top">
    
     <table cellSpacing=0 cellPadding=0 width=384 border=0> 
              <tr >
              	 <td background="image/main/1-3.gif" height="30"  align="left"><span  style="padding-left:60px"><a class="styleWhite" href="mainAction.do?action=toSecondaryPage">中心新闻</a></span> </td>
              </tr>
              <tr>
                <td height=8></td>
              </tr>
     </table>
     <table width="384" border=0 cellPadding=0 cellSpacing=2> 
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流试验基地正式投运</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流压交流试流试验基试验基地正式投运</A> </div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流试验基是士大夫地正式投运</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流试验基各个感啊事实地正式投运</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流试验基地正式投运</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12   href="mainAction.do?action=toDetailPage" 
                  target=_blank>刘振亚先后会见三家银行董事长</A> <img src="image/main/hot.gif" alt="" width="26" height="13" /></div></td>
              <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>公司《大型电网企业全面社会责任管理》成果...</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
              <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>公司积极推进直升机项目</A> <img src="image/main/hot.gif" alt="" width="26" height="13" /></div></td>
                <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>以科学发展观统领全局 推动公司平稳较快发展</A> <img src="image/main/hot.gif" alt="" width="26" height="13" /></div></td>
                <td class=black12 width="19%">( 12-23 )</td>
          </tr> 
    </table>   
    
     <table cellSpacing=0 cellPadding=0 width=384 border=0> 
              <tr>
              	 <td background="image/main/1-3.gif" width="184" height="30"><span  style="padding-left:60px"><A class="styleWhite"  href="mainAction.do?action=toSecondaryPage" 
>培训动态</A></span></td>
              </tr>
              <tr>
                <td height=8></td>
              </tr>
     </table>
     <table width="384" border=0 cellPadding=0 cellSpacing=2> 
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流试验基地正式投运</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12   href="mainAction.do?action=toDetailPage" 
                  target=_blank>刘振亚先后会见三家银行董事长</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
              <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>公司《大型电网企业全面社会责任管理》成果...</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
              <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>公司积极推进直升机项目</A> <img src="image/main/hot.gif" alt="" width="26" height="13" /></div></td>
                <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>以科学发展观统领全局 推动公司平稳较快发展</A> </div></td>
                <td class=black12 width="19%">( 12-23 )</td>
          </tr> 
    </table>    
    
     <table cellSpacing=0 cellPadding=0 width=384 border=0> 
              <tr>
              	 <td background="image/main/1-3.gif" width="184" height="30"><span style="padding-left:60px"><a href="mainAction.do?action=toSecondaryPage" class="styleWhite">精品项目</a></span></td>
              </tr>
              <tr>
                <td height=8></td>
              </tr>
     </table>
     <table width="384" border=0 cellPadding=0 cellSpacing=2> 
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12  href="mainAction.do?action=toDetailPage" 
                  target=_blank>特高压交流试验基地正式投运</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
                <td class=black12 width="19%">( 12-29 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12   href="mainAction.do?action=toDetailPage" 
                  target=_blank>刘振亚先后会见三家银行董事长</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
              <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>公司《大型电网企业全面社会责任管理》成果...</A> <img src="image/main/new1.gif" alt="" width="22" height="9" /></div></td>
              <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>公司积极推进直升机项目</A> </div></td>
                <td class=black12 width="19%">( 12-26 )</td>
          </tr>
          <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="77%" height=17><div align="left"><A class=black12 
                  href="mainAction.do?action=toDetailPage" 
                  target=_blank>以科学发展观统领全局 推动公司平稳较快发展</A> </div></td>
                <td class=black12 width="19%">( 12-23 )</td>
          </tr> 
    </table>    
    
     
     </td>
    <td width="188" valign="top">
    
    
   <Table width=180 border=0 align="center" cellPadding=0 cellSpacing=2> 
              <tr>
                <td width="176" height="25" align=center background="image/main/mainright_top1.gif" bgColor=#f3f3f1 class="red14b STYLE47">专 题 报 道</td>
              </tr>
              <tr>
                <td align=middle >
                  <Table cellSpacing=0 cellPadding=0 width=172 align=center  border=0 > 
                  <tr>
                      <td height=10 colspan="2"></td></tr>
                    <tr>
                    <tr>
                      <td width="30"  align="left" ><img src="image/main/1-4.gif" alt="" width="30" height="30" /></td>
                      <td width="142"  align="left" ><a href="mainAction.do?action=toSecondaryPage" class=g13>国际合作</a></td>
                    </tr>
                    <tr>
                      <td height=6 colspan="2"></td></tr>
                    <tr>
                      <td background=image/main/xxgl.gif height=1 colspan="2"></td></tr>
                    <tr>
                      <td height=6 colspan="2"> </td></tr>
                      
                      
                      
                      <tr>
                      <td height=10 colspan="2"></td></tr>
                    <tr>
                    <tr>
                      <td width="30"  align="left" ><img src="image/main/1-4.gif" alt="" width="30" height="30" /></td>
                      <td width="142"  align="left" ><a href="mainAction.do?action=toSecondaryPage" class=g13>先进性教育</a></td>
                    </tr>
                    <tr>
                      <td height=6 colspan="2"></td></tr>
                    <tr>
                      <td background=image/main/xxgl.gif height=1 colspan="2"></td></tr>
                    <tr>
                      <td height=6 colspan="2"> </td></tr>
                      
                      <tr>
                      <td height=10 colspan="2"></td></tr>
                    <tr>
                    <tr>
                      <td width="30"  align="left" ><img src="image/main/1-4.gif" alt="" width="30" height="30" /></td>
                      <td width="142"  align="left" ><a href="mainAction.do?action=toSecondaryPage" class=g13>党风建设</a></td>
                    </tr>
                    <tr>
                      <td height=6 colspan="2"></td></tr>
                    <tr>
                      <td background=image/main/xxgl.gif height=1 colspan="2"></td></tr>
                    <tr>
                      <td height=6 colspan="2"> </td></tr>
                 
                      </Table>                    </td>
                    </tr>
                    
                    
                  </Table>
    

     <Table cellSpacing=0 cellPadding=0 width="180" border=0> 
              <tr>
                <td height=5></td>
                </tr>
     </Table>
     <Table width=175 border=0 align="center" cellPadding=0 cellSpacing=0 > 
              <tr>
                <td width="170" height="25" align="center" background="image/main/mainright_top1.gif" class="red14b STYLE47">党 校 链 接</td>
              </tr>
              <tr>
                <td align="center">&nbsp;</td>
              </tr>
              
              <tr>
                <td align=middle>

                <SELECT class=black12 
                  style="BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; WIDTH: 95%; BORDER-BOTTOM: #cccccc 1px solid; BACKGROUND-COLOR: #ffffff" 
                  onchange="window.open(this.options[this.selectedIndex].value,'_blank')" 
                  name=select3> <OPTION value=http://www.ncpg.com.cn/ 
                    selected>公司各单位链接 <OPTION  value=http://www.sgepri.com/>国网电力科学研究院</OPTION> <OPTION 
                    value=http://www.epcri.com/>国网北京电力建设研究院</OPTION> <OPTION 
                    value=http://www.chinasperi.com.cn/>国网北京经济技术研究院</OPTION> 
                    <OPTION 
                    value=http://www.zxpower.com/index1.htm>中兴电力实业发展有限公司</OPTION> 
                    <OPTION value=http://anneng.cn/>中国安能建设总公司</OPTION> <OPTION 
                    value=http://www.sgxinyuan.com.cn/index.aspx>国网新源控股有限公司</OPTION> 
                    <OPTION value=http://www.sgac.net.cn/>国网交流工程建设有限公司</OPTION> 
                    <OPTION value=http://www.sgccit.com.cn/>国网信息通信有限公司</OPTION> 
                    <OPTION 
                    value=http://www.zdc.com.cn/index.jsp>中国电力财务有限公司</OPTION> 
                    <OPTION value=http://www.cetic.com.cn/>中国电力技术进出口公司</OPTION> 
                    <OPTION 
                    value=http://www.ssps.com.cn/htm/>国网深圳能源发展集团有限公司</OPTION> 
                    <OPTION value=http://www.cepp.com.cn/>中国电力出版社有限公司</OPTION> 
                    <OPTION value=http://www.sgdsm.com>电力需求侧管理指导中心</OPTION> 
                    <OPTION 
                    value=http://www.ydthlife.com/>英大泰和人寿保险股份有限公司</OPTION></SELECT>                </td></tr>
              
              <tr>
                <td align=middle height=1></td></tr>
              
              <tr>
              <td height=1></td></tr></Table>

     <Table cellSpacing=0 cellPadding=0 width="170" border=0> 
              <tr>
                <td height=5></td>
                </tr>
     </Table>
     <Table width=175 border=0 align="center" cellPadding=0 cellSpacing=0 > 
              <tr>
                <td width="170" height="25" align="center" background="image/main/mainright_top1.gif" class="red14b STYLE47">公 司 链 接</td>
              </tr>
              <tr>
                <td align="center">&nbsp;</td>
              </tr>
              
              <tr>
                <td align=middle>

                <SELECT class=black12 
                  style="BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; WIDTH: 95%; BORDER-BOTTOM: #cccccc 1px solid; BACKGROUND-COLOR: #ffffff" 
                  onchange="window.open(this.options[this.selectedIndex].value,'_blank')" 
                  name=select3> <OPTION value=http://www.ncpg.com.cn/ 
                    selected>公司各单位链接 <OPTION  value=http://www.sgepri.com/>国网电力科学研究院</OPTION> <OPTION 
                    value=http://www.epcri.com/>国网北京电力建设研究院</OPTION> <OPTION 
                    value=http://www.chinasperi.com.cn/>国网北京经济技术研究院</OPTION> 
                    <OPTION 
                    value=http://www.zxpower.com/index1.htm>中兴电力实业发展有限公司</OPTION> 
                    <OPTION value=http://anneng.cn/>中国安能建设总公司</OPTION> <OPTION 
                    value=http://www.sgxinyuan.com.cn/index.aspx>国网新源控股有限公司</OPTION> 
                    <OPTION value=http://www.sgac.net.cn/>国网交流工程建设有限公司</OPTION> 
                    <OPTION value=http://www.sgccit.com.cn/>国网信息通信有限公司</OPTION> 
                    <OPTION 
                    value=http://www.zdc.com.cn/index.jsp>中国电力财务有限公司</OPTION> 
                    <OPTION value=http://www.cetic.com.cn/>中国电力技术进出口公司</OPTION> 
                    <OPTION 
                    value=http://www.ssps.com.cn/htm/>国网深圳能源发展集团有限公司</OPTION> 
                    <OPTION value=http://www.cepp.com.cn/>中国电力出版社有限公司</OPTION> 
                    <OPTION value=http://www.sgdsm.com>电力需求侧管理指导中心</OPTION> 
                    <OPTION 
                    value=http://www.ydthlife.com/>英大泰和人寿保险股份有限公司</OPTION></SELECT>                </td></tr>
              
              <tr>
                <td align=middle height=1></td></tr>
              
              <tr>
              <td height=1></td></tr></Table>
                
     <Table cellSpacing=0 cellPadding=0 width="170" border=0> 
              <tr>
                <td height=5></td>
                </tr>
     </Table>
     <Table width=175 border=0 align="center" cellPadding=0 cellSpacing=0 > 
              <tr>
                <td width="170" height="25" align="center" background="image/main/mainright_top1.gif" class="red14b STYLE47">常 用 链 接</td>
              </tr>
              <tr>
                <td align="center">&nbsp;</td>
              </tr>
              
              <tr>
                <td align=middle>

                <SELECT class=black12 
                  style="BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; WIDTH: 95%; BORDER-BOTTOM: #cccccc 1px solid; BACKGROUND-COLOR: #ffffff" 
                  onchange="window.open(this.options[this.selectedIndex].value,'_blank')" 
                  name=select3> <OPTION value=http://www.ncpg.com.cn/ 
                    selected>公司各单位链接 <OPTION  value=http://www.sgepri.com/>国网电力科学研究院</OPTION> <OPTION 
                    value=http://www.epcri.com/>国网北京电力建设研究院</OPTION> <OPTION 
                    value=http://www.chinasperi.com.cn/>国网北京经济技术研究院</OPTION> 
                    <OPTION 
                    value=http://www.zxpower.com/index1.htm>中兴电力实业发展有限公司</OPTION> 
                    <OPTION value=http://anneng.cn/>中国安能建设总公司</OPTION> <OPTION 
                    value=http://www.sgxinyuan.com.cn/index.aspx>国网新源控股有限公司</OPTION> 
                    <OPTION value=http://www.sgac.net.cn/>国网交流工程建设有限公司</OPTION> 
                    <OPTION value=http://www.sgccit.com.cn/>国网信息通信有限公司</OPTION> 
                    <OPTION 
                    value=http://www.zdc.com.cn/index.jsp>中国电力财务有限公司</OPTION> 
                    <OPTION value=http://www.cetic.com.cn/>中国电力技术进出口公司</OPTION> 
                    <OPTION 
                    value=http://www.ssps.com.cn/htm/>国网深圳能源发展集团有限公司</OPTION> 
                    <OPTION value=http://www.cepp.com.cn/>中国电力出版社有限公司</OPTION> 
                    <OPTION value=http://www.sgdsm.com>电力需求侧管理指导中心</OPTION> 
                    <OPTION 
                    value=http://www.ydthlife.com/>英大泰和人寿保险股份有限公司</OPTION></SELECT>                </td></tr>
              
              <tr>
                <td align=middle height=1></td></tr>
              
              <tr>
              <td height=1></td></tr></Table>    </td>
  </tr>
</table>        </td>
      </tr>
    </table>   </td>
  </tr>
  <tr >
  
  
    <td colspan="2" style=" padding-left:5px; padding-right:5px">
 
  <DIV id=demom style="OVERFLOW: hidden; WIDTH: 760px">
                  <Table borderColor=#ffffff cellSpacing=0 cellPadding=0  width=610 align=center border=0 cellspace="0"> 
                    <tr>
                      <td id=demom1 vAlign=center>
                        <Table borderColor=#ffffff height=104 cellSpacing=0   cellPadding=0 align=center border=0> 
                          <tr>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95   border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=吉林省吉林供电公司积极开展秋检工作 
                                href="mainAction.do?action=toDetailPage"  target=_blank><IMG height=100 src="image/main/d.jpg"  width=149 border=0></A></td>
                                </tr>
                              </Table>
                           </td>
                           <td vAlign=bottom noWrap align=middle width=3></td>
                           <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95  border=0> 
                                <tr>
                                <td bgColor=#ffffff><A  title=750千伏兰—平—乾工程进入电气安装高峰   href="mainAction.do?action=toDetailPage" 
                                target=_blank><IMG height=100 src="image/main/b.jpg"   width=149 border=0></A></td>
                                </tr>
                              </Table>
                           </td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=定格 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/2008/10/174096.shtml" 
                                target=_blank><IMG height=100 src="image/main/c.jpg" 
                  width=149 border=0></A></td>
                                </tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=带电作业技能竞赛决赛开赛 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/2008/9/173256.shtml" 
                                target=_blank><IMG height=100 src="image/main/d.jpg" 
                  width=149 border=0></A></td>
                                </tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=福建莆田电业局：金牌服务与奥运同行 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/2008/7/168747.shtml" 
                                target=_blank><IMG height=100 src="image/main/d.jpg" 
                  width=149 border=0></A></td>
                                </tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=国家电网公司奥林匹克展示中心正式开放 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/2008/7/166075.shtml" 
                                target=_blank><IMG height=100 src="image/main/c.jpg" 
                  width=149 border=0></A></td>
                                </tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=服务队队员正在宣传安全用电知识 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/2008/6/165536.shtml" 
                                target=_blank><IMG height=100 src="image/main/d.jpg" 
                  width=149 border=0></A></td></tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=长寿局助农抗旱受欢迎 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/2008/6/164499.shtml" 
                                target=_blank><IMG height=100 src="image/main/b.jpg" 
                  width=149 border=0></A></td></tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=人民网：奥运火炬走进山区希望小学 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/163040.shtml" 
                                target=_blank><IMG height=100 src="image/main/d.jpg" 
                  width=149 border=0></A></td></tr></TBODY></Table></td>
                            <td vAlign=bottom noWrap align=middle width=3></td>
                            <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95 
                              border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title=新疆电力公司大力宣传“绿色电网” 
                                href="http://www.sgcc.com.cn/xwzx/gsyw/tpxw/162189.shtml" 
                                target=_blank><IMG height=100 src="image/main/c.jpg" 
                  width=149 border=0></A></td></tr></TBODY></Table></td>
                            
                             <td vAlign=bottom noWrap align=middle   width=3></td>
                          </tr>
                       </Table>
                      </td>
                      <td id=demom2 vAlign=top></td></tr></Table></DIV>
      <SCRIPT language=javascript>

var speed=15

demom2.innerHTML=demom1.innerHTML

function Marquee1(){

if(demom2.offsetWidth-demom.scrollLeft<=0)

demom.scrollLeft-=demom1.offsetWidth

else{

demom.scrollLeft++

}

}

var MyMar1=setInterval(Marquee1,speed)

demom.onmouseover=function() {clearInterval(MyMar1)}

demom.onmouseout=function() {MyMar1=setInterval(Marquee1,speed)}

</SCRIPT>                
 
 
    </td>
  </tr>
  
    <tr>
  
  

          <td colspan="2">
    <Table cellSpacing=0 cellPadding=0 width="100%" border=0> 
        <tr>
          <td height=1 bgcolor="#ffffff" class="g12">&nbsp;</td>
        </tr>
        <tr>
          <td height=2><img src="image/main/book0021.gif" width="770" height="14"></td>
        </tr>
      </Table>

     </td>
   
  </tr>
        
  
</table>

<div id="img" style="position:absolute;">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align=right><span onclick="closediv();" style="cursor:hand">[关闭]</span></td>
	</tr>
	<tr>
		<td><a href="" target=_blank><img border=0  src="image/main/float.gif"></a></td>
	</tr>
</table>
</div>

<script language="JavaScript" src="js/float.js"></script>
<script language="JavaScript">
start();
function closediv() {
	img.style.display = "none";
}
</script>


<Table cellSpacing=0 cellPadding=0 width="770" border=0  align="center"> 
      
       
        <tr >
          <td height=10 bgcolor="#e6e6e6">&nbsp;</td>
        </tr> </Table>
        
<%@ include file="bottom.jsp"%>

</body>

</HTML>
