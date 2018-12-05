<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: zoud
  Date: 2018/12/4
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是一个简单的甲基化数据库</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 class="text-primary">这是一个简单的甲基化数据库</h1>
    </div>

    <h3>1. 确定数据模型 (Model), 设计创建数据库表 <small><a href="#entity" class="btn btn-xs btn-success" data-toggle="collapse">查看</a></small></h3>
    <div class="panel panel-info collapse" id="entity">
        <div class="panel-body">
            <h4 class="text-success">此数据库有三个表，即三个实体</h4>
            <ol>
                <li><strong>物种 Species</strong>, 一个物种对应多个基因</li>
                <li><strong>基因 Gene</strong>, 一个基因对应多个不同状态的甲基化值</li>
                <li><strong>甲基化 Methylation</strong></li>
            </ol>
        </div>
    </div>


    <h3>2. 增删改查之 <strong style="font-size: 32px; color: #7c1c08">"查"</strong>, 做个简单的查询，查看数据库中所有物种的信息.</h3>
    <h3>3. 增删改查之 <strong style="font-size: 32px; color: #4cae4c">"增"</strong>, 添加一个物种.</h3>

    <hr>
    <h4>物种信息</h4>
    <a href="#addSpecies" class="btn btn-info" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> 添加物种</a>
    <hr>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>英文名</th>
            <th>中文名</th>
            <th>拉丁名</th>
            <th>物种类型</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${fn:length(list) == 0}">
                <tr>
                    <td colspan="3">暂无物种信息，点击<a href="#addSpecies" data-toggle="modal">这里</a>添加</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${list}" var="s">
                    <tr>
                        <td>${s.speciesCommonName}</td>
                        <td>${s.speciesChineseName}</td>
                        <td>${s.speciesLatinName}</td>
                        <td>${s.speciesType}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>


    <!-- Modal -->
    <div class="modal fade" id="addSpecies" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加物种</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/species/save" method="post">
                        <div class="form-group">
                            <label class="control-label col-md-2">英文名</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="speciesCommonName" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2">中文名</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="speciesChineseName" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2">拉丁名</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="speciesLatinName" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2">物种类型</label>
                            <div class="col-md-6">
                                <select name="speciesType" class="form-control">
                                    <option value="Plant">Plant</option>
                                    <option value="Animal">Animal</option>
                                    <option value="Virus">Virus</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2">
                                <input type="reset" class="btn btn-default" value="重置" />
                                <input type="submit" class="btn btn-primary" value="提交"/>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#species").click(function () {
            $("#tbs").show();
            $("#tbc").empty();
            $.ajax({
                url: '${pageContext.request.contextPath}/species/type/plant',
                type: 'GET',
                success: function (data) {
                    return $.each(data, function (i, species) {

                        $("#tbc").append("<tr>" +
                            "<td>" + species.speciesCommonName + "</td>" +
                            "<td>" + species.speciesLatinName + "</td>" +
                            "<td>" + species.speciesType + "</td>" +
                            "</tr>");
                    });
                }
            })

        })
    });
</script>
</body>
</html>
