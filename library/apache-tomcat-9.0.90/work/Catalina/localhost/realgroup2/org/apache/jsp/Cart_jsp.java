/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.90
 * Generated at: 2024-07-13 10:43:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/Users/vannhat/Documents/Codevn_Jsp_Servlet/realprojectassignment/build/web/WEB-INF/lib/jstl-impl.jar!/META-INF/c.tld", Long.valueOf(1343794618000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl.jar", Long.valueOf(1720867229459L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("                <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/style.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/reset.min.css\">\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("              href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"loadTotalMoney()\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"shopping-cart\">\n");
      out.write("                <div class=\"px-4 px-lg-0\">\n");
      out.write("\n");
      out.write("                    <div class=\"pb-5\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-12 p-5 bg-white rounded shadow-sm mb-5\">\n");
      out.write("\n");
      out.write("                                    <!-- Shopping cart table -->\n");
      out.write("                                    <div class=\"table-responsive\">\n");
      out.write("                                        <table class=\"table\">\n");
      out.write("                                            <thead>\n");
      out.write("                                            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"p-2 px-3 text-uppercase\">Sản Phẩm</div>\n");
      out.write("                                            </th>\n");
      out.write("                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"py-2 text-uppercase\">Đơn Giá</div>\n");
      out.write("                                            </th>\n");
      out.write("                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"py-2 text-uppercase\">Màu Sắc</div>\n");
      out.write("                                            </th>\n");
      out.write("                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"py-2 text-uppercase\">Delivery</div>\n");
      out.write("                                            </th>\n");
      out.write("<!--                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"py-2 text-uppercase\">Kích Thước</div>\n");
      out.write("                                            </th>-->\n");
      out.write("                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"py-2 text-uppercase\">Số Lượng</div>\n");
      out.write("                                            </th>\n");
      out.write("                                            <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                <div class=\"py-2 text-uppercase\">Xóa</div>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("\n");
      out.write("                                            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- End -->\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"row py-5 p-4 bg-white rounded shadow-sm\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-6\">\n");
      out.write("                                <div class=\"bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold\">Thành tiền</div>\n");
      out.write("\n");
      out.write("                                <div class=\"p-4\">\n");
      out.write("                                    <ul class=\"list-unstyled mb-4\" id=\"contentTotalMoney\">\n");
      out.write("                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalMoney}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" $</strong></li>\n");
      out.write("                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${shippingFee}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</strong></li>\n");
      out.write("                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${VAT}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" $</strong></li>\n");
      out.write("                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\n");
      out.write("                                            <h5 class=\"font-weight-bold\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalMoneyVAT}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" $</h5>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul><a href=\"order\" class=\"btn btn-dark rounded-pill py-2 btn-block text-white\">Thanh Toán</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("                \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        function loadTotalMoney() {\n");
      out.write("            $.ajax({\n");
      out.write("                url: \"/realgroup2/totalMoneyCart\",\n");
      out.write("                type: \"get\", //send it through get method\n");
      out.write("                data: {\n");
      out.write("\n");
      out.write("                },\n");
      out.write("                success: function (responseData) {\n");
      out.write("                    document.getElementById(\"contentTotalMoney\").innerHTML = responseData;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function deleteOrder(productId) {\n");
      out.write("            $.ajax({\n");
      out.write("                url: \"/realgroup2/deleteCart?productID=\" + productId,\n");
      out.write("                type: \"get\", //send it through get method\n");
      out.write("                data: {\n");
      out.write("\n");
      out.write("                },\n");
      out.write("                success: function (responseData) {\n");
      out.write("                    document.getElementById(\"contentTotalMoney\").innerHTML = responseData;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        window.addEventListener(\"load\", function loadAmountCart() {\n");
      out.write("            $.ajax({\n");
      out.write("                url: \"/realgroup2/loadAllAmountCart\",\n");
      out.write("                type: \"get\", //send it through get method\n");
      out.write("                data: {\n");
      out.write("\n");
      out.write("                },\n");
      out.write("                success: function (responseData) {\n");
      out.write("                    document.getElementById(\"amountCart\").innerHTML = responseData;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }, false);\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /Cart.jsp(34,44) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error!=null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <div class=\"alert alert-danger\" role=\"alert\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                            </div>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /Cart.jsp(39,40) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mess!=null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <div class=\"alert alert-success\" role=\"alert\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mess}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                            </div>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /Cart.jsp(70,44) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/Cart.jsp(70,44) '${listCart}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${listCart}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /Cart.jsp(70,44) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("o");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("\n");
            out.write("                                                <tr>\n");
            out.write("                                                    <th scope=\"row\">\n");
            out.write("                                                        <div class=\"p-2\">\n");
            out.write("\n");
            out.write("                                                            <img src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" alt=\"\" width=\"70\" class=\"img-fluid rounded shadow-sm\">\n");
            out.write("\n");
            out.write("                                                            <div class=\"ml-3 d-inline-block align-middle\">\n");
            out.write("                                                                <h5 class=\"mb-0\"> <a href=\"#\" class=\"text-dark d-inline-block\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a></h5><span class=\"text-muted font-weight-normal font-italic\"></span>\n");
            out.write("                                                            </div>\n");
            out.write("                                                        </div>\n");
            out.write("                                                    </th>\n");
            out.write("                                                    <td class=\"align-middle\"><strong>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("$</strong></td>\n");
            out.write("                                                    <td class=\"align-middle\"><strong>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.color}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</strong></td>\n");
            out.write("                                                    <td class=\"align-middle\"><strong>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.delivery}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</strong></td>\n");
            out.write("\n");
            out.write("<!--                                                    <td class=\"align-middle\">\n");
            out.write("                                                        <strong></strong>\n");
            out.write("                                                    </td>-->\n");
            out.write("\n");
            out.write("                                                    <td class=\"align-middle\">\n");
            out.write("                                                        <a href=\"subAmountCart?productID=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("&amount=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.quantity}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"><button class=\"btnSub\">-</button></a> \n");
            out.write("                                                        <strong>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.quantity}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</strong>\n");
            out.write("                                                        <a href=\"addAmountCart?productID=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("&amount=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.quantity}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"><button class=\"btnAdd\">+</button></a>\n");
            out.write("                                                    </td>\n");
            out.write("                                                    <td class=\"align-middle\"><a href=\"deleteCart?productID=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"text-dark\">\n");
            out.write("                                                            <button type=\"button\" onclick=\"deleteOrder(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.product.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(")\" class=\"btn btn-danger\">Delete</button>\n");
            out.write("                                                        </a>\n");
            out.write("                                                    </td>\n");
            out.write("                                                </tr> \n");
            out.write("                                            ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
