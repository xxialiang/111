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
<script type="text/javascript" src="js/echarts.js"></script>
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
<div id="goods" style="width: 1200px; height: 650px"></div>
<script>
	var gChart = echarts.init(document.getElementById("goods"));
	var url = "Goods";
	$.getJSON(url).done(function(json) {
		gname = json.gname;
		gcount = json.gcount;
		goption = {
			    title : {
			        text: '订单数量按产品类别的分布',
			        x: 'center'
			    },
			    tooltip : {
			        trigger: 'item',
					x: 'right',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        x: 'left',
			        y: '5%',
					data : gname,
			        selected: function() {
			        	var selected = {};
			        	for (var i = 0; i < gname.length; i++) {
			        		selected[gname] = i < 4;
			        	}
			        	return selected;
			        }()
			    },
			    toolbox: {
			        show : true,
					x: 'right',
					y: '5%',
			        feature : {
			            dataView : {show: true, readOnly: false},
			            saveAsImage : {show: true},
			            restore : {show: true}
			        }
			    },
			    series : [
			        {
			            name: '订单数量',
			            type: 'pie',
			            radius : '60%',
			            center: ['50%', '50%'],
						data : function() {
							var serie = [];
							for (var i = 0; i < gname.length; i++) {
								var item = {
									name : gname[i],
									value : gcount[i]
								};
								serie.push(item);
							}
							return serie;
						}(),
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			        }
			    ]
			};
		gChart.setOption(goption);
	})
</script>
</body>
</html>