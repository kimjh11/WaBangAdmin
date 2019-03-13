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
<%@ include file="../search/menu.jspf" %><br/>
<style>
	*{text-align:left}
	h2{text-align:center}
	select{display:none}
	#start, .on, .on1 {display:inline}
	#submit{width:200px; height:50px;text-align:center; margin:1% 40%}
</style>
<script src="index.js"></script>
<script>
var num = 0;
var num2 = 0;
var la1 = 0;
var la2 = 0;
var change = "tImg";
	$(function(){
		//input-file을 선택할 시 이미지를 나오게 하는곳
		for(i=0;i<=2;i++){
			$("#thumbName"+i).click(function(){
				if(i<=2){
					change = "tImg"+i;
					$("#textbox").append("<img id="+change+" class='img-thumbnail col-sm-3'>");
				}
				
			})
		}
		
	//옵션, 색깔 text 추가하는 것--------------
		 var add1 = 2;
		 var add2 = 2;
		 
		$(".plus").click(function(){
				if($(this).attr("id")=="optionAdd"){
					 ++add1;
					$("#add1").append("<input type='text' id='option"+add1+"' name='option"+add1+"' class='col-sm-3' style='margin:0 6px'/>");
				 }else if($(this).attr("id")=="colorAdd"){
				 	 ++add2;
					 $("#add2").append("<input type='text' id='color"+add2+"' name='color"+add2+"' class='col-sm-2' style='margin:0 6px'/>");
			 }
			});
		$(".delete").click(function(){
			if($(this).attr("id")=="optiondel"){
				add1++;
				$("#add1").html("<input type='text' id='option"+add1+"' name='option"+add1+"' placeholder='*ex) 퀸사이즈(+100,000)' class='col-sm-3' style='margin:0 6px'/>");
			 }else if($(this).attr("id")=="colordel"){
				 add2++;
				 $("#add2").html("<input type='text' id='color"+add2+"' name='color"+add2+"' class='col-sm-2' style='margin:0 6px'/>");
		 }
		})
			var opt = "";
			var clt = "";
		$("#submit").click(function(){	
			for(i=0;i<=add1+1;i++){
				if($("#option"+i).val()!=null){
					opt += $("#option"+i).val()+"|";
				}
			}
			$("#optionTotal").val(opt);
			for(i=0;i<=add1+1;i++){
				if($("#color"+i).val()!=null){
					clt += $("#color"+i).val()+"|";
				}
			}
			$("#colorTotal").val(clt);
		})
	//--카테고리 split------------
	$("#op").click(function(){
		var category = "${vo.category}";
		var cateSplit = category.split("|");
		var big = cateSplit[0];
		var mid = cateSplit[1];
		var small = cateSplit[2];
			$("#start").val(big);
			$(".mid").val(mid);
			$(".last").val(small);
			for(i=0;i<=21;i++){
				if($("#mid"+i).val()==mid){
					$("#mid"+i).addClass("on");
				}
				if($("#small"+i).val()==small){
					$("#small"+i).addClass("on1");
				}
			}
	//--옵션과 색깔 넣어주는곳-----------------------------
	})
		var op = "${vo.option}";
		var opSplit = op.split("|");
		for(i=0;i<=opSplit.length-2;i++){
			if(i<=0){
				$("#add1").append("<input type='text' id='option"+i+"' name='option"+i+"' placeholder='*ex) 퀸사이즈(+100,000)' class='col-sm-3' value='"+opSplit[i]+"' />");
			}else{
				$("#add1").append("<input type='text' id='option"+i+"' name='option"+i+"' class='col-sm-3' value='"+opSplit[i]+"' />");
			}
		}
		var col = "${vo.color}";
		var colSplit = col.split("|");
		for(i=0;i<=colSplit.length-2;i++){
				$("#add2").append("<input type='text' id='color"+i+"' name='color"+i+"' class='col-sm-3' value='"+colSplit[i]+"'/>");
		}
	//--저장된 이미지 출력시키는 곳 ------------------------------	
	var thumbnails = "${vo.thumbnail}";
	var tnSplit = thumbnails.split("|");
	var detail = "${vo.detail}";
	
	var img = "${vo.detail}"
		$("#board").append("<img src='/WaBangAdmin/item/itemImg/"+img+"' id='"+num+"'/>");
		$("#detail").append("<label id='detailName' name='detailName'>"+detail+"<b id='deClose' class='del'>X</b></labal>")
	
	for(i=0;i<=tnSplit.length-2;i++){
		change = "tImg"+i;
		<%-- $("#textbox").append("<img src='<%=request.getContextPath()%>/item/itemImg/"+tnSplit[i]+"/>'"); --%>
		if(i==0){
			$("#thumbnailName").append("<label id='thumbText"+i+"' name='thumbText"+i+"'>"+tnSplit[i]+"<b id='thumbClose"+i+"' class='del'> X</b></label>");
		}else{
			$("#thumbnailName").append("<label class='col-sm-1'></label><label id='thumbText"+i+"' name='thumbText"+i+"'>"+tnSplit[i]+"<b id='thumbClose"+i+"' class='del'> X</b></label>");	
		}
		$("#textbox").append("<img src='/WaBangAdmin/item/itemImg/"+tnSplit[i]+"' class='img-thumbnail col-sm-3' id='"+change+"'/>");
	}
	if(tnSplit.length-2==0){
		$("#thumbName1").attr("type","file");
		$("#thumbName2").attr("type","file");
	}if(tnSplit.length-2==1){
		$("#thumbName2").attr("type","file");
	}
	//썸네일 이름 X표를 누를시	
	
		var delThumb = "";
		$(".del").click(function(){
			if($(this).attr("id")=="deClose"){
				$("#image").attr("type","file");
				$("#detailName").html("");
				$("#delImage").attr("value",img)
			}
			for(i=0;i<=tnSplit.length-1;i++){
				if($(this).attr("id")=="thumbClose"+i){
					change = "tImg"+i;
					//$("#thumbDel").append("<input type='hidden' id='delThumb"+i+"' name='delThumb"+i+"' />")
					$("#delThumb").attr("value",function(){
						delThumb += tnSplit[i]+"|";
						return delThumb;
					});
					$("#thumbText"+i).html("");
					$("#thumbName"+i).attr("type","file");
				}
			}
		})
	})//$(function(){}

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
	  
	var changeFile = function(event) {
		    var input = event.target;
		
		    var reader = new FileReader();
		    reader.onload = function(){
		      var dataURL = reader.result;
		      var output = document.getElementById(change);
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
<div><h2>상품수정</h2></div>
<div>  <!--전체를 담는 블럭 -->
	<form method = "post" action="${ctx}item/itemEditOk.do" enctype="multipart/form-data" class="form-horizontal"> 
		<div> <!-- 상품 코드  -->
			<label class="col-sm-1">상품 코드 </label>
			<input class="col-sm-5" type="text" id="p_Code" name="p_Code" readonly value="${vo.code}"/>
		</div>
		<div id="ca"> <!-- 카테고리 select들  -->
			<label class="col-sm-1">카테고리</label>
				<!-- 카테고리들 추가 -->
				<span id="category" onChange="cateVal()"></span><input type="button" id="op" value="op" onClick="cateVal()"/>
					<input type="hidden" id="cateTotal" name="cateTotal"/>
					
		</div>
		<div> <!-- 상품명, 판매금액, 할인률   -->
			<label class="col-sm-1">상품명</label> 
				<input type="text" class="col-sm-5" id="p_Title" name="p_Title" value="${vo.name}"/><br/>
			<label class="col-sm-1">판매금액 </label>
				<input type="text" id="p_Pprice" name="p_Price" value="${vo.price}"/>원 
			<label class="col-sm-1">할인률 </label>
				<input type="text" id="sale" name="sale" value="${vo.discount}"/>%	
		</div>
		<div> <!-- 옵션, 색깔 -->
			<label class="col-sm-1">옵션</label>
				<input type="hidden" id="optionTotal" name="optionTotal"/>
			<span id="add1">
				<!-- 옵션input text들 들어오는 곳 -->
			</span>
				<input type="button" id="optionAdd" value="+" class="plus"/>
				<input type="button" id="optiondel" value="-" class="delete"/><br/>
			<label class="col-sm-1">색깔</label>
				<input type="hidden" id="colorTotal" name="colorTotal"/>
			<span id="add2">
				<!-- 색깔 input text들 들어오는 곳 -->
			</span>
				<input type="button" id="colorAdd" value="+" class="plus"/>
				<input type="button" id="colordel" value="-" class="delete"/><br/>
		</div>
		<div>  <!-- 썸네일 이미지,  -->
			<label class="col-sm-1">썸네일</label>
				<input type="hidden" id="thumbName0" name="thumbName0" accept='image/*' onchange='changeFile(event)'/>
				<input type="hidden" id="thumbName1" name="thumbName1" accept='image/*' onchange='changeFile(event)'/>
				<input type="hidden" id="thumbName2" name="thumbName2" accept='image/*' onchange='changeFile(event)'/>
				<span id="thumbnailName"></span>
				<!-- <span id="thumbDel"></span> -->
				<input type="hidden" id="delThumb" name="delThumb"/>
				<div id="textbox" style="border:1px solid">
					<!-- 저장된 이미지 뽑는곳 -->
				</div>
			<label class="col-sm-1">내용</label>
				<span id="detail">
					<input type="hidden" id="image" name="image" accept='image/*' onchange='openFile(event)'/>
					<input type="hidden" id="delImage" name="delImage" />
				</span>
					
				<div id="board" style="border:1px solid"></div>
		</div>
		<input type="submit" id="submit" value="수정" />
	</form>
</div>
</body>
</html>