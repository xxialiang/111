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
<script type="text/javascript" src="js/map/china.js"></script>
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
<div id="province&city_bar3D" style="width: 1295px; height: 700px"></div>
<script type="text/javascript">
	var pChart2 = echarts.init(document.getElementById("province&city_bar3D"));
	var url = "Province";
	$.getJSON(url).done(function(json) {
		pname = json.pname;
		pcount = json.pcount;
		var geoCoordMap = {
				"浙江": [120.22, 30.26],
				"四川": [104.06, 30.57],
				"江苏": [118.78, 32.06],
				"广东": [113.31, 23.12],
				"江西": [115.89, 28.69],
				"陕西": [108.94, 34.34],
				"黑龙江": [126.66, 45.77],
				"山东": [117.02, 36.68],
				"上海": [121.48,31.23],
				"河北": [114.52, 38.05],
				"福建": [119.33, 26.05],
				"安徽": [117.28, 31.87],
				"甘肃": [103.82, 36.06],
				"吉林": [125.32, 43.82],
				"辽宁": [123.43, 41.81],
				"湖北": [114.32, 30.58],
				"河南": [113.65, 34.76],
				"湖南": [112.98, 28.21],
				"北京": [116.40, 39.93],
				"重庆": [106.55, 29.56],
				"青海": [101.77, 36.64],
				"广西": [108.29, 22.81],
				"天津": [117.21, 39.14],
				"云南": [102.71, 24.88],
				"贵州": [106.71, 26.63],
				"山西": [112.55, 37.89],
				"内蒙古": [111.66, 40.83],
				"宁夏": [106.20, 38.50],
				"海南": [110.33, 20.02],
				"新疆": [87.56, 43.84],
				"西藏": [91.11, 29.66]
		};
		var convertData = function (data) {
		    var res = [];
		    for (var i = 0; i < data.length; i++) {
		        var geoCoord = geoCoordMap[data[i].name];
		        if (geoCoord) {
		            res.push({
		                name: data[i].name,
		                value: geoCoord.concat(data[i].value)
		            });
		        }
		    }
		    return res;
		};
		poption2 = {
				backgroundColor: '#FFFFFF',
				title: {
					text: '订单数量按省的分布',
					x: 'center'
				},
				tooltip: {
					show: true
				},
				geo3D: {
				    map: 'china',
				    shading: 'lambert',
				    emphasis: {
				    	label: {
				    		show: true
				    	}
				    },
				    light: {
				        main: {
				        	color: '#fff',
				            intensity: 1.2,
				            shadow: true,
				            shadowQuality: 'high',
				            alpha: 30,
				            beta: 10
				        },
				        ambient: {
				            intensity: 0.3
				        },
				        ambientCubemap: {
				            exposure: 1,
				            diffuseIntensity: 0.5
				        }
				    },
				    viewControl: {
				        distance: 50,
				        panMouseButton: 'left',
				        rotateMouseButton: 'right'
				    },
				    groundPlane: {
				        show: true,
				        color: '#FFFFFF'
				    },
				    postEffect: {
				        enable: true,
				        bloom: {
				            enable: false
				        },
				        SSAO: {
				            radius: 1,
				            intensity: 1,
				            enable: true
				        },
				        depthOfField: {
				            enable: false,
				            focalRange: 10,
				            blurRadius: 10,
				            fstop: 1
				        }
				    },
				    temporalSuperSampling: {
				        enable: true
				    },
				    itemStyle: {
				    	color: '#FFFFFF',
				    	opacity: 1,
				    	borderWidth: 1,
				    	borderColor: '#000'
				    },
				    regionHeight: 2
				},
				visualMap: {
				    max: 1000,
				    calculable: true,
				    realtime: true,
				    inRange: {
				        color: ['#313695', '#4575b4', '#74add1', '#fdae61', '#f46d43', '#d73027', '#a50026']
				    },
				    outOfRange: {
				        colorAlpha: 0
				    }
				},
				series: [{
					name: '订单数量',
				    type: 'bar3D',
				    coordinateSystem: 'geo3D',
				    shading: 'lambert',
				    roam: true,
				    data: convertData(
				    		function() {
								var serie = [];
								for(var i = 0; i < pname.length; i++) {
									var item = {
										name: pname[i],
										value: pcount[i]
									};
									serie.push(item);
								}
								return serie;
							}()
				    ),
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
			        },
				    barSize: 2,
				    minHeight: 0.2,
				    silent: true,
				    itemStyle: {
				    }
				}]
			};;
		pChart2.setOption(poption2);
	})
</script>
</body>
</html>