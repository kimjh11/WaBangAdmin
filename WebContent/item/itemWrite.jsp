<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>제목</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<%@ include file="../search/menu.jspf" %>
<style>
	select{display:none}
	#start, .on, .on1 {display:inline}
</style>
<script src="index.js"></script>
<script>
var num = 0;
var la1 = 0;
var la2 = 0;
	$(function(){
		//input-file을 선택할 시 이미지를 나오게 하는곳
		$("input[type=file]").on("click",function(){
			if($(this).attr("id")=="thumbnail1"){	
				num++
				$("#textbox").append("<img id='"+num+"' class='img-thumbnail col-sm-3'>")
			}else if($(this).attr("id")=="thumbnail2"){	
				num++
				$("#textbox").append("<img id='"+num+"' class='img-thumbnail col-sm-3'>")
			}else if($(this).attr("id")=="thumbnail3"){	
				num++
				$("#textbox").append("<img id='"+num+"' class='img-thumbnail col-sm-3'>")
			}else if($(this).attr("id")=="image"){
				num++
				$("#board").append("<img id='"+num+"' class='img-image col-sm-3'>")
			}
		})
	//옵션, 색깔 text 추가하는 것--------------
		 var add1 = 1;
		 var add2 = 1;
		 
		$(".bt").click(function(){
				if($(this).attr("id")=="optionAdd"){
					 add1++;
					$("#add1").append("<input type='text' id='option"+add1+"' name='option"+add1+"' class='col-sm-3' style='margin:0 6px'/>");
				 }else if($(this).attr("id")=="colorAdd"){
				 	 add2++;
					 $("#add2").append("<input type='text' id='color"+add2+"' name='color"+add2+"' class='col-sm-2' style='margin:0 6px'/>");
			 }
			})
			var opt = "";
			var clt = "";
		$("#submit").click(function(){	
			for(i=1;i<=add1;i++){
				opt += $("#option"+i).val()+"|";
			}
			$("#optionTotal").val(opt);
			for(i=1;i<=add1;i++){
				clt += $("#color"+i).val()+"|";
			}
			$("#colorTotal").val(clt);
		})
	//-----------------
	})
	//파일을 읽어 이미지로 띄워주는 곳 
	// 사실 잘 모르겠음;;
	var openFile = function(event) {
	    var input = event.target;
	
	    var reader = new FileReader();
	    reader.onload = function(){
	      var dataURL = reader.result;
	      var output = document.getElementById(num);
	      output.src = dataURL;
	    };
	    reader.readAsDataURL(input.files[0]);
	  };
	  
	 //큰카테고리를 선택할때 중간카테고리가 변경되는 것 ----------------
	  var mid;
	 function select(){
		 for(i=1;i<=4;i++){
			 if($("#start option:selected").attr("id")=="big"+i){
				 $(".on").removeClass("on");
				 $("#mid"+i).addClass("on");
			 }
		 }
	}
	//중간카테고리를 선택할때 소카테고리가 변경되는것 ------------------
	 function select1(){
		 for(i=1;i<=21;i++){
			 if($("#mid1 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
				 }
		 }
	 }
	 function select2(){
		 for(i=1;i<=21;i++){
			 if($("#mid2 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
				 }
		 }
	 }
	 function select3(){
		 for(i=1;i<=21;i++){
			 if($("#mid3 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
				 }
		 }
	 }
	 function select4(){
		 for(i=1;i<=21;i++){
			 if($("#mid4 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
			 }
		 }
	 }
	 //---------------------------------------------------------
	 //선택한 카테고리의 값을 합한곳
	 function cateVal(){
		 var val = $("#start").val()+"|";
		 for(i=1;i<=4;i++){
			 if($("#mid"+i).attr("class")=="mid on"){
			 val += $("#mid"+i).val()+"|";
			 }
		 }
		 for(i=1;i<=21;i++){
			 if($("#small"+i).attr("class")=="last on1"){
				 val += $("#small"+i).val();
				 }
		 }
		 $("#cateTotal").val(val);
	 }
	 //----------------------------------------
	 
</script>
</head>
<body>
<div><h2>상품등록</h2></div>
<div>  <!--전체를 담는 블럭 -->
	<form method = "post" action="<%=request.getContextPath()%>/item/itemWriteOk.do" enctype="multipart/form-data" class="form-horizontal"> 
		<div> <!-- 상품 코드  -->
			<label class="col-sm-1">상품 코드 </label>
			<input class="col-sm-5" type="text" id="p_Code" name="p_Code"/>
		</div>
		<div> <!-- 카테고리 select들  -->
			<label class="col-sm-1">카테고리</label>
				<!-- 카테고리들 추가 -->
				<span id="category" onClick="cateVal()"></span><br/>
					<input type="hidden" id="cateTotal" name="cateTotal"/>
		</div>
		<div> <!-- 상품명, 판매금액, 할인률   -->
			<label class="col-sm-1">상품명</label> 
				<input type="text" class="col-sm-5" id="p_Title" name="p_Title"/><br/>
			<label class="col-sm-1">판매금액 </label>
				<input type="text" id="p_Pprice" name="p_Price"/>원 
			<label class="col-sm-1">할인률 </label>
				<input type="text" id="sale" name="sale" value="0" />%	
		</div>
		<div> <!-- 옵션, 색깔 -->
			<label class="col-sm-1">옵션</label>
			<span id="add1">
				<input type="hidden" id="optionTotal" name="optionTotal"/>
				<input type="text" id="option1" name="option1" class="col-sm-3"/>
			</span>
				<input type="button" id="optionAdd" value="+" class="bt"><br/>
			<label class="col-sm-1">색깔</label>
			<span id="add2">
				<input type="hidden" id="colorTotal" name="colorTotal"/>
				<input type="text" id="color1" name="color1" class="col-sm-2"/>
			</span>
				<input type="button" id="colorAdd" value="+" class="bt"/>
		</div>
		<div>  <!-- 썸네일 이미지,  -->
			<label class="col-sm-1">썸네일</label>
				<input type="file" id="thumbnail1" name="thumbnail1" accept='image/*' onchange='openFile(event)'/>
				<input type="file" id="thumbnail2" name="thumbnail2" accept='image/*' onchange='openFile(event)'/>
				<input type="file" id="thumbnail3" name="thumbnail3" accept='image/*' onchange='openFile(event)'/>
				<div id="textbox" name="textbax" contentEditable="false" style="border:1px solid"></div>
				<div id="label1"></div>
			<label class="col-sm-1">이미지</label>
				<input type="file" id="image" name="image" accept='image/*' onchange='openFile(event)'/>
				<div id="board" name="board"contentEditable="true" style="border:1px solid;height:500px;overflow:scroll"></div>
				<div id="label2"></div>
		</div>
		<input type="submit" id="submit" value="등록" />
	</form>
</div>
</body>
</html>