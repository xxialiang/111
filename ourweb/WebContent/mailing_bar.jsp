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
<div id="mailing_bar" style="width: 1200px; height: 650px"></div>
<script type="text/javascript">
	var mChart2 = echarts.init(document.getElementById("mailing_bar"));
	var url = "Mailing_bar";
	$.getJSON(url).done(function(json) {
		mname = json.mname;
		mdate = json.mdate;
		mdcount1 = json.mdcount1;
		mdcount2 = json.mdcount2;
		mdcount3 = json.mdcount3;
		mdcount4 = json.mdcount4;
		moption2 = {
		    baseOption: {
		        timeline: {
		        	x: '10%',
		            axisType: 'category',
		            width: '75%',
		            realtime: true,
		            loop: true,
		            autoPlay: true,
		            currentIndex: 0,
		            playInterval: 1000,
		            controlStyle: {
		                position: 'right'
		            },
		            data: [
		                '2015','2016','2017','2018'
		            ]
		        },
		        tooltip: {
		        },
		        legend: {
		        	x: 'left',
		            y: '5%',
		            data: mname,
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
		        calculable : true,
		        grid: {
		            top: 80,
		            bottom: 100,
		            tooltip: {
		                trigger: 'axis',
		                axisPointer: {
		                    type: 'shadow',
		                    label: {
		                        show: true,
		                        formatter: function (params) {
		                            return params.value.replace('\n', '');
		                        }
		                    }
		                }
		            }
		        },
		        xAxis: [
		            {
		                'type':'category',
		                'axisLabel':{'interval':0},
		                'data':[
		                    '3月','6月','9月','12月'
		                ],
		                splitLine: {show: false}
		            }
		        ],
		        yAxis: [
		            {
		                type: 'value',
		            }
		        ],
		        series: [
		            {name: mname[0], type: 'bar'},
		            {name: mname[1], type: 'bar'},
		            {name: mname[2], type: 'bar'},
		            {name: mname[3], type: 'bar'}
		        ]
		    },
		    options: [
		        {
		            title: {
		            	text: '2015年订单数量按邮寄方式和月份的分布',
		            	x: 'center'
		            },
		            series: [
		                {data: [mdcount1[0], mdcount1[1], mdcount1[2], mdcount1[3]]},
		                {data: [mdcount2[0], mdcount2[1], mdcount2[2], mdcount2[3]]},
		                {data: [mdcount3[0], mdcount3[1], mdcount3[2], mdcount3[3]]},
		                {data: [mdcount4[0], mdcount4[1], mdcount4[2], mdcount4[3]]}
		            ]
		        },
		        {
		            title : {text: '2016年订单数量按邮寄方式和月份的分布'},
		            series : [
		            	{data: [mdcount1[4], mdcount1[5], mdcount1[6], mdcount1[7]]},
		                {data: [mdcount2[4], mdcount2[5], mdcount2[6], mdcount2[7]]},
		                {data: [mdcount3[4], mdcount3[5], mdcount3[6], mdcount3[7]]},
		                {data: [mdcount4[4], mdcount4[5], mdcount4[6], mdcount4[7]]}
		            ]
		        },
		        {
		            title : {text: '2017年订单数量按邮寄方式和月份的分布'},
		            series : [
		            	{data: [mdcount1[8], mdcount1[9], mdcount1[10], mdcount1[11]]},
		                {data: [mdcount2[8], mdcount2[9], mdcount2[10], mdcount2[11]]},
		                {data: [mdcount3[8], mdcount3[9], mdcount3[10], mdcount3[11]]},
		                {data: [mdcount4[8], mdcount4[9], mdcount4[10], mdcount4[11]]}
		            ]
		        },
		        {
		            title : {text: '2018年订单数量按邮寄方式和月份的分布'},
		            series : [
		            	{data: [mdcount1[12], mdcount1[13], mdcount1[14], mdcount1[15]]},
		                {data: [mdcount2[12], mdcount2[13], mdcount2[14], mdcount2[15]]},
		                {data: [mdcount3[12], mdcount3[13], mdcount3[14], mdcount3[15]]},
		                {data: [mdcount4[12], mdcount4[13], mdcount4[14], mdcount4[15]]}
		            ]
		        }
		    ]
		};;
		mChart2.setOption(moption2);
	})
</script>
</body>
</html>