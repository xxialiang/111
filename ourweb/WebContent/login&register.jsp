<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/mdui.css" />
<link rel="stylesheet" href="css/app.css" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body style="background:#99e3e8">
<header>
	<div>超市订单信息分析系统</div>
</header>
<script src="js/mdui.js"></script>
<script type="text/javascript">
    var a_idx = 0;
    jQuery(document).ready(function($) {
        $("body").click(function(e) {
            var a = new Array("富强","民主","文明","和谐","自由","平等","公正","法治","爱国","敬业","诚信","友善");
            var $i = $("<span></span>").text(a[a_idx]);
            a_idx = (a_idx + 1) % a.length;
            var x = e.pageX,
            y = e.pageY;
            $i.css({
                "z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
                "top": y - 20,
                "left": x,
                "position": "absolute",
                "font-weight": "bold",
                "color": "rgb("+~~(255*Math.random())+","+~~(255*Math.random())+","+~~(255*Math.random())+")"
            });
            $("body").append($i);
            $i.animate({
                "top": y - 180,
                "opacity": 0
            },
            1500,
            function() {
                $i.remove();
            });
        });
    });
</script>
<h1>登录/注册</h1>
<div class="login" style="margin-top:50px;">
    <div class="header">
        <div class="switch" id="switch">
            <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
			<div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
    	<div class="web_login" id="web_login">
    		<div class="login-box">
    		    <div class="login_form">
    			    <form action="Login" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
    			    <input type="hidden" name="did" value="0"/>
    			    <input type="hidden" name="to" value="log"/>
    			    <div class="uinArea" id="uinArea">
    				    <label class="input-tips" for="u">帐号：</label>
    				    <div class="inputOuter" id="uArea">
    					    <input type="text" id="u" name="uname" class="inputstyle" autocomplete="off" />
    				    </div>
    			    </div>
    			    <div class="pwdArea" id="pwdArea">
    				    <label class="input-tips" for="p">密码：</label>
    				    <div class="inputOuter" id="pArea">
    					    <input type="password" id="p" name="password1" class="inputstyle" />
    				    </div>
    			    </div>
    			    <div style="padding-left:50px;margin-top:20px;">
    			        <input type="submit" value="登 录" style="width:150px;" class="button_blue" />
    			    </div>
    			    </form>
    		    </div>
    	   </div>
    	</div>
    </div>
    <div class="qlogin" id="qlogin" style="display: none; ">
    	<div class="web_login">
    		<form name="form2" id="regUser" accept-charset="utf-8" action="Register" method="post">
    		<input type="hidden" name="to" value="reg"/>
    		<input type="hidden" name="did" value="0"/>
    		<ul class="reg_form" id="reg-ul">
    		<div id="userCue" class="cue"></div>
    			<li>
    				<label for="user"  class="input-tips2">用户名：</label>
    				<div class="inputOuter2">
    					<input type="text" id="user" name="uname" maxlength="16" class="inputstyle2" autocomplete="off" />
                   </div>
    			</li>
    			<li>
    				<label for="passwd" class="input-tips2">密码：</label>
    				<div class="inputOuter2">
    					<input type="password" id="passwd" name="password1" maxlength="16" class="inputstyle2" />
                   </div>  
                </li>
                <li>
                    <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="password2" maxlength="16" class="inputstyle2" />
                    </div>  
                </li>
                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg" style="margin-top:10px;margin-left:85px;width:150px;" class="button_blue" value="注册" />
                    </div>
                </li>
    		</ul>
    	    </form>
    	</div>
    </div>
</div>
</body>
</html>