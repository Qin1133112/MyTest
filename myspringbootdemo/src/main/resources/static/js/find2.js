import axios from 'vue/axios.js';
Vue.prototype.$axios = axios;

export default {  
  name: 'layout',  
  components: {  
    'axios': axios,  
   }  
}  


// 实例化vue对象（MVVM中的View Model）
var Vue =new Vue({
        // vm控制的区块为id为app的div，此div中的所有vue指令均可以被vm解析
        el:'#app',
        data:{
        // 数据 （MVVM中的Model）   
        users:[
        	{
        		id: '',
                name:'',
                sex: '',
                age: ''
        	}
        ],
        name:''
        },
        methods:{
            getApiData:function() {
            //设置请求路径
            var url  = "http://192.168.1.6:9090/springboot/find";                
            // 发送请求:将数据返回到一个回到函数中
            _this= this;
            // 并且响应成功以后会执行then方法中的回调函数
            axios.get(url).then(function(result) {
                // result是所有的返回回来的数据
                // 包括了响应报文行
                // 响应报文头
                // 响应报文体
                console.log(result.data);
                _this.users = result.data;
            });    
            }
        }
    })