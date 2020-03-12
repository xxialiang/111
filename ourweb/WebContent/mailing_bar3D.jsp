<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="css/mdui.css" />
<link rel="stylesheet" href="css/app.css" />
<script type="text/javascript" src="js/echarts.simple.min.js"></script>
<script type="text/javascript" src="js/echarts.common.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/echarts-gl.min.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
<header>
	<a class="backprev" href="javascript:history.back(-1);">
		<i class="mdui-icon material-icons">&#xe314;</i>
	</a>
	<div class="head-middle">超市订单信息分析系统</div>
	<div class="head-right">
		<button class="mdui-btn app-btn" mdui-drawer="{target: '#left-drawer'}"><i class="mdui-icon material-icons">&#xe5d3;</i></button>
		<div class="mdui-drawer mdui-drawer-right mdui-drawer-close" id="left-drawer">
			<ul class="mdui-list app-slide-menu app-collapse-menu" mdui-collapse="{accordion: true}">
			    <li class="mdui-list-item mdui-ripple app-list-home">
				    <a href="index.jsp" class="app-list-item-link mdui-text-left">
					    <div class="mdui-list-item-content">
							<i class="mdui-list-item-icon mdui-icon material-icons">
						    &#xe88a;
						    </i>首页
					    </div>
				    </a>
			    </li>
			    <li class="mdui-collapse-item  app-hide-list  app-collapse-list">
					<div class="mdui-collapse-item-header mdui-list-item mdui-ripple  mdui-p-x-0">
						<div class="menu-click mdui-list-item-content mdui-text-left" onClick="">
							信息查询
							<i class="mdui-collapse-item-arrow mdui-icon material-icons mdui-float-right">
								&#xe5cc;
							</i>
						</div>
					</div>
					<ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="ordersqry.jsp" class="app-list-item-link mdui-text-left">
								订单查询
							</a>
						</li>
					</ul>
				</li>
				<li class="mdui-collapse-item  app-hide-list  app-collapse-list">
					<div class="mdui-collapse-item-header mdui-list-item mdui-ripple  mdui-p-x-0">
						<div class="menu-click mdui-list-item-content mdui-text-left" onClick="">
							信息总览
							<i class="mdui-collapse-item-arrow mdui-icon material-icons mdui-float-right">
								&#xe5cc;
							</i>
						</div>
					</div>
					<ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="orderdate.jsp" class="app-list-item-link mdui-text-left">
								订单日期
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="mailing.jsp" class="app-list-item-link mdui-text-left">
								邮寄方式
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="goods.jsp" class="app-list-item-link mdui-text-left">
								产品类别
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="province&city.jsp" class="app-list-item-link mdui-text-left">
								订单地区
							</a>
						</li>
					</ul>
				</li>
				<li class="mdui-collapse-item  app-hide-list  app-collapse-list">
					<div class="mdui-collapse-item-header mdui-list-item mdui-ripple  mdui-p-x-0">
						<div class="menu-click mdui-list-item-content mdui-text-left" onClick="">
							邮寄方式
							<i class="mdui-collapse-item-arrow mdui-icon material-icons mdui-float-right">
								&#xe5cc;
							</i>
						</div>
					</div>
					<ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="mailing_pie.jsp" class="app-list-item-link mdui-text-left">
								按年/月的饼状分布
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="mailing_bar.jsp" class="app-list-item-link mdui-text-left">
								按年/月的柱状分布
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="mailing_line.jsp" class="app-list-item-link mdui-text-left">
								按年/月的折线分布
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="mailing_bar3D.jsp" class="app-list-item-link mdui-text-left">
								按年/月的3D分布
							</a>
						</li>
					</ul>
				</li>
				<li class="mdui-collapse-item app-hide-list  app-collapse-list">
				    <div class="mdui-collapse-item-header mdui-list-item mdui-ripple  mdui-p-x-0">
						<div class="menu-click mdui-list-item-content mdui-text-left">
							产品类别
							<i class="mdui-collapse-item-arrow mdui-icon material-icons mdui-float-right">
								&#xe5cc;
							</i>
						</div>
					</div>
					<ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="goods_pie.jsp" class="app-list-item-link mdui-text-left">
								按年/月的饼状分布
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="goods_bar.jsp" class="app-list-item-link mdui-text-left">
								按年/月的柱状分布
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="goods_line.jsp" class="app-list-item-link mdui-text-left">
								按年/月的折线分布
							</a>
				        </li>
				        <li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="goods_bar3D.jsp" class="app-list-item-link mdui-text-left">
								按年/月的3D分布
							</a>
				        </li>
			        </ul>
			   </li>
			   <li class="mdui-collapse-item app-hide-list  app-collapse-list">
				    <div class="mdui-collapse-item-header mdui-list-item mdui-ripple  mdui-p-x-0">
						<div class="menu-click mdui-list-item-content mdui-text-left">
							订单地区
							<i class="mdui-collapse-item-arrow mdui-icon material-icons mdui-float-right">
								&#xe5cc;
							</i>
						</div>
					</div>
					<ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="province&city_map.jsp" class="app-list-item-link mdui-text-left">
								按省/市的地图分布
							</a>
						</li>
						<li class="mdui-list-item mdui-ripple app-sub-list  app-hide-list">
							<a href="province&city_bar3D.jsp" class="app-list-item-link mdui-text-left">
								按省的3D分布
							</a>
						</li>
			        </ul>
			   </li>
			   <li class="mdui-list-item mdui-ripple app-list-home">
				    <a href="login&register.jsp" class="app-list-item-link mdui-text-left">
					    <div class="mdui-list-item-content" style="text-align:right;">
							<i class="mdui-list-item-icon mdui-icon material-icons">
						    </i>注销&nbsp;(●'◡'●)&nbsp;
					    </div>
				    </a>
			    </li>
			</ul>
		</div>
	</div> 
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
<div id="mailing_bar3D" style="width: 1200px; height: 650px"></div>
<script type="text/javascript">
	var mChart4 = echarts.init(document.getElementById("mailing_bar3D"));
	var url = "Mailing_bar";
	$.getJSON(url).done(function(json) {
		mname = json.mname;
		mdate = json.mdate;
		mdcount1 = json.mdcount1;
		mdcount2 = json.mdcount2;
		mdcount3 = json.mdcount3;
		mdcount4 = json.mdcount4;
		moption4 = {
				title : {
			        text: '订单数量按邮寄方式和月份的分布',
			        x: 'center'
			    },
			    tooltip: {},
			    visualMap: {
			        max: 600,
			        inRange: {
			            color: [
			            	'#313695', '#4575b4', '#74add1', '#abd9e9',
			            	'#e0f3f8', '#ffffbf', '#fee090', '#fdae61',
			            	'#f46d43', '#d73027', '#a50026'
			            ]
			        }
			    },
			    xAxis3D: {
			        type: 'category',
			        data: mdate
			    },
			    yAxis3D: {
			        type: 'category',
			        data: mname
			    },
			    zAxis3D: {
			        type: 'value'
			    },
			    grid3D: {
			        boxWidth: 120,
			        boxDepth: 48,
			        viewControl: {
			        },
			        light: {
			            main: {
			                intensity: 1.2,
			                shadow: false
			            },
			            ambient: {
			                intensity: 0.3
			            }
			        }
			    },
			    series: [{
			    	name: '订单数量',
			        type: 'bar3D',
			        data: [
			        	[mdate[0],mname[0],mdcount1[0]],[mdate[1],mname[0],mdcount1[1]],[mdate[2],mname[0],mdcount1[2]],[mdate[3],mname[0],mdcount1[3]],
			        	[mdate[4],mname[0],mdcount1[4]],[mdate[5],mname[0],mdcount1[5]],[mdate[6],mname[0],mdcount1[6]],[mdate[7],mname[0],mdcount1[7]],
			        	[mdate[8],mname[0],mdcount1[8]],[mdate[9],mname[0],mdcount1[9]],[mdate[10],mname[0],mdcount1[10]],[mdate[11],mname[0],mdcount1[11]],
			        	[mdate[12],mname[0],mdcount1[12]],[mdate[13],mname[0],mdcount1[13]],[mdate[14],mname[0],mdcount1[14]],[mdate[15],mname[0],mdcount1[15]],
			        	[mdate[0],mname[1],mdcount2[0]],[mdate[1],mname[1],mdcount2[1]],[mdate[2],mname[1],mdcount2[2]],[mdate[3],mname[1],mdcount2[3]],
			        	[mdate[4],mname[1],mdcount2[4]],[mdate[5],mname[1],mdcount2[5]],[mdate[6],mname[1],mdcount2[6]],[mdate[7],mname[1],mdcount2[7]],
			        	[mdate[8],mname[1],mdcount2[8]],[mdate[9],mname[1],mdcount2[9]],[mdate[10],mname[1],mdcount2[10]],[mdate[11],mname[1],mdcount2[11]],
			        	[mdate[12],mname[1],mdcount2[12]],[mdate[13],mname[1],mdcount2[13]],[mdate[14],mname[1],mdcount2[14]],[mdate[15],mname[1],mdcount2[15]],
			        	[mdate[0],mname[2],mdcount3[0]],[mdate[1],mname[2],mdcount3[1]],[mdate[2],mname[2],mdcount3[2]],[mdate[3],mname[2],mdcount3[3]],
			        	[mdate[4],mname[2],mdcount3[4]],[mdate[5],mname[2],mdcount3[5]],[mdate[6],mname[2],mdcount3[6]],[mdate[7],mname[2],mdcount3[7]],
			        	[mdate[8],mname[2],mdcount3[8]],[mdate[9],mname[2],mdcount3[9]],[mdate[10],mname[2],mdcount3[10]],[mdate[11],mname[2],mdcount3[11]],
			        	[mdate[12],mname[2],mdcount3[12]],[mdate[13],mname[2],mdcount3[13]],[mdate[14],mname[2],mdcount3[14]],[mdate[15],mname[2],mdcount3[15]],
			        	[mdate[0],mname[3],mdcount4[0]],[mdate[1],mname[3],mdcount4[1]],[mdate[2],mname[3],mdcount4[2]],[mdate[3],mname[3],mdcount4[3]],
			        	[mdate[4],mname[3],mdcount4[4]],[mdate[5],mname[3],mdcount4[5]],[mdate[6],mname[3],mdcount4[6]],[mdate[7],mname[3],mdcount4[7]],
			        	[mdate[8],mname[3],mdcount4[8]],[mdate[9],mname[3],mdcount4[9]],[mdate[10],mname[3],mdcount4[10]],[mdate[11],mname[3],mdcount4[11]],
			        	[mdate[12],mname[3],mdcount4[12]],[mdate[13],mname[3],mdcount4[13]],[mdate[14],mname[3],mdcount4[14]],[mdate[15],mname[3],mdcount4[15]]
			        ],
			        shading: 'lambert',
			        label: {
			            textStyle: {
			                fontSize: 16,
			                borderWidth: 1
			            }
			        },
			        emphasis: {
			            label: {
			                textStyle: {
			                    fontSize: 20,
			                    color: '#900'
			                }
			            },
			            itemStyle: {
			                color: '#900'
			            }
			        }
			    }]
			};;
		mChart4.setOption(moption4);
	})
</script>
</body>
</html>