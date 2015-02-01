	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<img src="/CVBangaloreSkin/images/header.jpg" width="1001" height="90"/>
		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html {
	background: #D8D9DB;
}

body {
	margin: 0px auto;
	width: 1000px;
	height: inherit;
	background: #FFF;
	overflow: visible;
}

div#menu {
	
}

div#copyright {
	display: none;
}
.logged_in_desc{
	font-family:Calibri;
	font:Calibri;
	font-size:16px;
	font-stretch:condensed;
	font-weight:700;
	color:#FFF;
	position:absolute;
	top:15px;
	left:30px;
	}
</style><!-- breaker                     -->


		<div id="menu">
			<div align='center' class="logged_in_desc">Logged in ${accountCenterForm.firstName} ${accountCenterForm.lastName} as ${accountCenterForm.loginName} </div>
			<ul class="menu">
				<li><a href="home.html" class="parent"> <span> Home
					</span> </a>
				</li>
				<li><a href="#" class="parent"> <span> Manage Resume</span> </a>
					<div>
						<ul>
							<li style="border-bottom: 1px dotted #ccc;"><a
								href="educationSummary.html"> <span> Education
										Information </span> </a>
							</li>
							<li style="border-bottom: 1px dotted #ccc;"><a
								href="employmentSummary.html"> <span> Employment
										Information </span> </a>
							</li>
							<li style="border-bottom: 1px dotted #ccc;"><a
								href="projectSummary.html"> <span> Project
										Information </span> </a>
							</li>
							<li style="border-bottom: 1px dotted #ccc;"><a
								href="profileSummaryInformation.html"> <span> Profile
										Summary Information </span> </a>
							</li>
							<li style="border-bottom: 1px dotted #ccc;"><a
								href="skillSummary.html"> <span> Skill
										Sets Information </span> </a>
							</li>
							<li style="border-bottom: 1px dotted #ccc;"><a
								href="recognitionSummary.html"> <span> Recognition </span> </a>
							</li>
							<li><a
								href="printResume"><span>
							    Generate Resume</span></a>
							</li>
						
						</ul>
					</div>
				</li>
				<li><a href="#" class="parent"> <span> Settings</span> </a>
					<div>
						<ul>
							<li><a
								href="changePassword.html"> <span>Change Password</span> </a>
							</li>
						</ul>
					</div>
				</li>
				<c:if test= "${accountCenterForm.isAdmin}">
					<li><a href="searchEmployee.html"> <span> Search </span> </a>
				</c:if>
				</li>
				<li><a href="help.html"> <span> Help </span> </a>
				</li>
				<li class="last"><a href="logout.html"> <span> Logout </span> </a>
				</li>
			</ul>
		</div>


	