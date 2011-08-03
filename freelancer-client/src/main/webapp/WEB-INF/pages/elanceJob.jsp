<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core_rt"
	xmlns:display="http://displaytag.sf.net">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

	<![CDATA[<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">]]>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="../css/style.css" />

<link rel="stylesheet" type="text/css" media="screen"
	href="../css/jquery-ui-1.8.custom.css" />

<script type="text/javascript" src="../js/jquery-1.6.2.min.js">//<![CDATA[ ]]></script>
<script type="text/javascript" src="../js/jquery.validate.min.js">//<![CDATA[ ]]></script>
<script type="text/javascript" src="../js/jquery-ui-1.8.custom.min.js">//<![CDATA[ ]]></script>

<script type="text/javascript">

			$(document).ready(function() {
				$("#dialog_job_more").dialog({
					modal: true,
					autoOpen: false,
					draggable: true,
					resizable: false,
					buttons: {
						'Close': function() {
							$(this).dialog('close');
						}
					}
				});	
				
				
				$(".tehbutton").click(function(){ 

					var name = $(this).attr("name");
					var description = $(this).attr("description");		
					var startDate = $(this).attr("startDate");	
					var endDate = $(this).attr("endDate");	
					var numProposals = $(this).attr("numProposals");	
					
					var html = "Name: " + name;
					
					html += "<br/>";
					 
					html += "Description: " + description;
					
					html += "<br/>";
					
	 			    html += "Start Date: " + startDate;
				    
	 			    html += "<br/>";
				    
	 			    html += "End Date: " + endDate;
	 			    
	 			    html += "<br/>";
				    
	 			    html += "Num proposals: " + numProposals;
					
					$("#dialog_job_more").html(html);			
					$("#dialog_job_more").dialog('open');
					
					return false;
			   }); 				
				
			});
			</script>

</head>

<body>

	<display:table uid="job" name="${jobList}" defaultsort="3"
		defaultorder="descending" pagesize="25" size="${size}"
		partialList="true" requestURI="" cellpadding="1" cellspacing="1" class="jobTable">

		<display:column property="name" title="Job Name" />
		<display:column property="category" title="Category" />
		<display:column property="startDate" title="Start date" />
		<display:column property="endDate" title="End date" />
		<display:column property="budget" title="Budget" />
		<display:column title="Job Url">
			<a href="${job.jobURL}" target="_blank">${job.jobURL}</a>
		</display:column>

		<display:setProperty name="basic.empty.showtable" value="true" />
		<display:setProperty name="paging.banner.group_size" value="10" />
		<display:setProperty name="paging.banner.item_name" value="Job" />
		<display:setProperty name="paging.banner.item_names" value="Jobs" />
		<display:setProperty name="paging.banner.onepage" value="One" />

		<display:column>
			<a class="tehbutton" href="#" name="${job.name}" description="${job.description}" startDate="${job.startDate}" endDate="${job.endDate}" numProposals="${job.numProposals}">More Details</a>
		</display:column>

	</display:table>

	<div id="dialog_job_more" style="display: none; ">
		
	</div>

</body>
	</html>

</jsp:root>