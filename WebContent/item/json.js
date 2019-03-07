$(function(){
	$.getJSON('category.json',function(allCategory){
		var cateTag = "";
		for(var mainCateTitle in allCategory){
			console.log(mainCateTitle);
		}
	})
});