import React from 'react';

class HelloWorld extends React.Component{

    render(){
        return (
            <div>我的第一个ReactJS的组件，name = {this.props.name}, 内容 = {this.props.children}</div>
        );
    }

}

export default HelloWorld;