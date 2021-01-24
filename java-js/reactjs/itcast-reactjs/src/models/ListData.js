import request from '../util/request';//用于异步请求数据

export default {
    namespace: 'list',//命名空间
    state: {// 这个state全局的,有很多的模型数据，通过namespace来做区分
        data: [],
        maxNum: 1
    },
    reducers : { // 定义的一些函数，这些函数一般用于更新state对象中的数据
				 // state：指的是更新之前的状态数据, result: 请求到的结果数据
        addNewData : function (state, result) { 
            if(result.data){ //如果result中存在data数据，说明是初始化数据，直接返回
                return result.data;
            }

            let maxNum = state.maxNum + 1;
            let newArr = [...state.data, maxNum];

            return {//通过return 返回更新后的数据 this.state数据发生变更->重新渲染页面
                data : newArr,
                maxNum : maxNum
            }
        }
    },
    effects: { //新增effects配置，用于异步加载数据
        *initData(params, sagaEffects) { //定义异步方法（带*）
            const {call, put} = sagaEffects; //获取到call、put方法
            const url = "/ds/list"; // 定义请求的url
            let data = yield call(request, url); //执行请求 拿到请求的结果data
            yield put({ // 调用reducers中的方法 来更新state对象中的数据
                type : "addNewData", //指定方法名
                data : data //第一个data是属性名，第二个data是ajax返回的数据
            });
        }
    }
}