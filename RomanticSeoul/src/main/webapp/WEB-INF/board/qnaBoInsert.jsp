<%@ include file="../common/common.jsp"%>
<script>
function writeForm(){
	location.href='<%=contextPath%>/qnaBoList.bo';
}
</script>
<link rel="stylesheet" href="css/qnainsert.css" type="text/css">
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Q&A</h2>
                </div>
                <div class="card-body">
                    <form method="get">
                        <div class="form-row m-b-55">
                            <div class="name">ID</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-12">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="id">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">TITLE</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="title">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">CONTENT</div>
                            <div class="value">
                                <div class="input-group">
                                    <textarea class="input--style-5" rows="4" cols="50" style="resize: none;"></textarea>
                                </div>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn--radius-2 btn--red" onclick="writeForm();">SUBMIT</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../common/footer.jsp" />