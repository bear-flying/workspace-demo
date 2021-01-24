//导出一个对象，暂时设置为空对象，后面再填充内容
export default {
    plugins: [
        ['umi-plugin-react', {
            dva : true , //开启了dva功能,
            antd : true  // 开启Ant Design功能
        }]
    ]
};