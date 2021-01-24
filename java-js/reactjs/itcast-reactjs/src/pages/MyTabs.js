import React from 'react';
import { Tabs } from 'antd'; // 导入需要使用的组件

const TabPane = Tabs.TabPane;

function callback(key) {
    console.log(key);
}

class MyTabs extends React.Component{

    render(){
        return (
            <Tabs defaultActiveKey="1" onChange={callback}>
                <TabPane tab="Tab 1" key="1">hello antd wo de 第一个 tabs</TabPane>
                <TabPane tab="Tab 2" key="2">Content of Tab Pane 2</TabPane>
                <TabPane tab="Tab 3" key="3">Content of Tab Pane 3</TabPane>
            </Tabs>
        )
    }

}

export default MyTabs;
