import request from "../util/request";

export default {
    namespace: 'userList',
    state: {
        list: []
    },

    effects: { //用来做异步处理的方法
        *initData(params, sagaEffects) {
            const {call, put} = sagaEffects;
            const url = "/ds/user/list"; //从mock/MockListData.js中读取模拟数据
            let data = yield call(request, url);
            yield put({
                type : "queryList", //函数调用（第22行）
                data : data
            });
        }
    },

    reducers: {
        queryList(state, result) {
            let data = [...result.data];
            return { //更新状态值  this.state数据发生变更->重新渲染页面
                list: data
            }
        }
    }

}