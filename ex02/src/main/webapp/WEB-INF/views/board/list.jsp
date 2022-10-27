<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tables</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>


	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board List Page</div>
				<button id="regBtn" type="button" class="btn btn-xs pul-right"
					style="float: right" style="text-align:right">Register New	Board</button>

				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>

						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}" /></td>
								<td><a
									href='/board/get?bno=<c:out value="${board.bno }" />'><c:out
											value="${board.title}" /></a></td>
											
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updatedate}" /></td>
							</tr>
						</c:forEach>


					</table>
					<!-- table 테그 끝 -->
					<!-- /.table-responsive -->
					<!-- modal 추가 -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title" id="myModalLabel">등록확인</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>

								</div>
								<div class="modal-body">
									<p>처리가 완료되었습니다.</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>

								</div>
							</div>
						</div>
					</div>
					<!-- modal 끝 -->


				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>

<script type="text/javascript">

	$(document).ready(function() {
		//글 등록 이후 모달팝업 생성
		var result = '<c:out value="${result}"/>';
		checkModal(result);
		
		history.replaceState({},null,null);
		
		function checkModal(result){
			if(result=== '' || history.state)	{ 
				return; 
			}
			
			if(parseInt(result)>0){
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			
			$("#myModal").modal("show");
		}

		$("#regBtn").on("click", function(){
			self.location="/board/register";
			
		});
		
	});
</script>
<%@include file="../includes/footer.jsp"%>