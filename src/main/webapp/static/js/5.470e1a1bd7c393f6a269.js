webpackJsonp([5],{eqKg:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a("Xxa5"),r=a.n(n),i=a("exGp"),o=a.n(i),l=a("bBUo"),c=a("mtWM"),u=a.n(c),s={data:function(){return{tableData:[],currentPage:1,limit:20,count:0}},created:function(){this.getCount(),this.getData()},components:{headTop:l.a},methods:{getData:function(){var t=this;return o()(r.a.mark(function e(){var a;return r.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:t.tableData=[],a="?page="+t.currentPage+"&limit="+t.limit,u.a.get("http://127.0.0.1:8080/getIdentPage"+a).then(function(e){0==e.data.code&&e.data.data.forEach(function(e){t.tableData.push(e)})},function(t){});case 3:case"end":return e.stop()}},e,t)}))()},getCount:function(){var t=this;return o()(r.a.mark(function e(){return r.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:u.a.get("http://127.0.0.1:8080/getIdentCount").then(function(e){0==e.data.code&&(t.count=e.data.data)},function(t){});case 1:case"end":return e.stop()}},e,t)}))()},handleSizeChange:function(t){this.limit=t,this.getData()},handleCurrentChange:function(t){this.currentPage=t,this.getData()}}},d={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"fillcontain"},[a("head-top"),t._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{"default-sort":[{prop:"id",order:"escending"},{prop:"date",order:"escending"}],data:t.tableData}},[a("el-table-column",{attrs:{sortable:"",prop:"id",label:"id",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"date",label:"创建日期",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{prop:"userName",label:"用户名",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{prop:"productName",label:"商品名称",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{prop:"account",label:"商品数量",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{prop:"points",label:"商品积分",width:"180"}})],1),t._v(" "),a("div",{staticClass:"Pagination"},[a("el-pagination",{attrs:{"current-page":t.currentPage,"page-sizes":[5,10,15,20],"page-size":t.limit,layout:"total, sizes, prev, pager, next, jumper",total:t.count},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1)],1)},staticRenderFns:[]};var p=a("VU/8")(s,d,!1,function(t){a("xznX")},null,null);e.default=p.exports},xznX:function(t,e){}});
//# sourceMappingURL=5.470e1a1bd7c393f6a269.js.map