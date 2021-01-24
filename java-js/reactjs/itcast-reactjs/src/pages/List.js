import React from 'react';
import { connect } from 'dva';

const namespace = "list";// umi框架启动，会自动读取models目录下的命名空间为list的model文件数据

// 第一个函数，作用：将page层和model层进行链接，返回modle中的数据
// 并且，将返回的数据，绑定到this.props中
@connect((state) => {
    return {// 拿到model数据中的data和maxNum，进行包裹{}后返回
			// 将返回的数据将被封装到this.props中（将数据映射到props），通过this.props.dataList方式获取
        dataList : state[namespace].data,//通过namespace进行区分model文件，state[namespace]进行获取数据
        maxNum : state[namespace].maxNum
    }
// 第二个函数，作用：将定义的函数绑定到this.props中，调用model层中定义的函数
}, (dispatch) => { // dispatch是内置函数，作用：可以调用model层定义的函数
    return { // 将返回的函数，绑定到this.props中（将方法映射到props）
        add : function () {
            dispatch({ //通过dispatch调用modle中定义的函数,通过type属性指定函数命名
                type : namespace + "/addNewData"  //格式：namespace/函数名
            });
        },
        init : () => { //初始化方法的定义
            dispatch({ 
                type : namespace + "/initData"
            });
        }
    }
})
class  List extends React.Component{
    componentDidMount(){//使用钩子方法，当组件加载完成之后，进行初始化操作
        //初始化的操作
        this.props.init();
    }

    render(){
        return (
            <div>
                <ul>
                    {
                        this.props.dataList.map((value,index)=>{
                            return <li key={index}>{value}</li>
                        })
                    }
                </ul>
                <button onClick={() => {
                    this.props.add();
                }}>点我</button>
            </div>
        );
    }
}

export default List;