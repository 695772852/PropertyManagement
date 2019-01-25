<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<style type="text/css">


</style>
</head>
<body>
     <div class="panel panel-primary">
	    <div class="panel-heading">
	        <h3 class="panel-title">理财产品信息管理系统</h3>
	    </div>
	    <div class="panel-body">
	    
	         <div class="table-responsive">
	          <div class="panel-body">
		         <form action="" class="form-inline">
		               <div class="form-group col-lg-3 col-md-3">
						    <label  for="id">产品代码</label>
						    <input type="text" class="form-control" id="name" placeholder="">
	                   </div>
	                   <div class="form-group col-lg-2 col-md-2">
						        <label for="risk">风险评级</label>
							    <select  class="form-control">
							      <option value="">请选择</option>
							      <option value="1">R1</option>
							      <option value="2">R2</option>
							      <option value="3">R3</option>
							    </select>
	                   </div>
	                   <div class="form-group col-lg-1 col-md-2">
	                        
						      
						    <button type="submit" class="btn btn-default" >查询</button>  
						   
					   </div>
					   <div class="form-group col-lg-1 col-md-2">
	                        
						      
						    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myAdd" >理财产品添加</button>  
						   
					   </div>
	          </form>
	        </div>  
				  <table class="table table-striped">
				    <thead>
				      <tr>
				        <th>产品代码</th>
				        <th>风险评级</th>
				        <th>预期收益</th>
				        <th>发售起始日期</th>
				        <th>发售截至日期</th>
				        <th>产品到期日期</th>
				       </tr>
				    </thead>
				    <tbody>
				    <c:forEach var="fp" items="${list }">
				      <tr>
				        <td>${fp.id }</td>
				        <td>${fp.risk }</td>
				        <td>${fp.income }</td>
				        <td>${fp.saleStarting }</td>
				        <td>${fp.saleEnd }</td>
				        <td>${fp.end }</td>
				      </tr>
			        </c:forEach>
				     </tbody>
				  </table>
				</div>
        </div>
        <div class="panel-footer">
                   面板脚注
        </div>
     </div>
     
     <div class="modal fade" id="myAdd" tabindex="-1" role="dialog" aria-labelledby="myUpdateLabel" aria-hidden="true">
	 <div class="modal-dialog">
	    <form action="doUpdate" class="form-inline form-horizontal" method="post">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myUpdateLabel">
					理财产品添加
				</h4>
			</div>
			<div class="modal-body">
						<div class="form-group">
						  <div class="row">
							<label class="col-sm-6 control-label" for="id1">产品代码:</label> 
							<div class="col-sm-6">
							  <input type="text"class="form-control" id="id" placeholder="产品代码">
						    </div>
						  </div>
						</div>
						<br><br>
						<div class="form-group">
						   <div class="row">
							<label class="col-sm-6 control-label" for="risk1">风险评级:</label>
							<div class="col-sm-6">
							    <select  class="form-control">
							      <option value="">请选择</option>
							      <option value="1">R1</option>
							      <option value="2">R2</option>
							      <option value="3">R3</option>
							    </select>
							 </div> 
							</div>  
						</div>
						<br><br>
						<div class="form-group">
						   <div class="row">
							<label class="col-sm-6 control-label" for="income">预期收益:</label>
							<div class="col-sm-6">
							 <input type="email"
								class="form-control" id="income"
								placeholder="预期收益">
							</div>
						   </div>
						</div>
						<br><br>
						<div class="form-group">
						  <div class="row">
							<label class="col-sm-6 control-label" for="saleStarting">发售起始日期:</label>
							<div class="col-sm-6">
							<input type="email"
								class="form-control" id="saleStarting"
								placeholder="yyyy-MM-dd格式">
							</div> 
						  </div>
						</div>
						<br><br>
						<div class="form-group">
						  <div class="row">
							<label class="col-sm-6 control-label" for="saleEnd">发售截至日期:</label> 
							<div class="col-sm-6">
								<input type="email"
									class="form-control" id="saleEnd"
									placeholder="yyyy-MM-dd格式">
							</div>
						  </div>
						</div>
						<br><br>
						<div class="form-group">
						  <div class="row">
							<label class="col-sm-6 control-label" for="end">产品到期日期:</label>
							<div class="col-sm-6">
							 <input type="email"
								class="form-control" id="end"
								placeholder="yyyy-MM-dd格式">
							</div>
						  </div>
						</div>
						

					</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal" value="关闭" >
				<input type="submit" class="btn btn-primary" value="保存"  />
			</div>
		</div><!-- /.modal-content -->
		</form>
	 </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
     
     
     
</body>
</html>