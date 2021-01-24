// pages/demo/index.js
const common = require('common.js')

Page({

  /**
   * 页面的初始数据
   */
  data: {
    staffA: { firstName: 'Hulk', lastName: 'Hu' },
    staffB: { firstName: 'Shang', lastName: 'You' },
    staffC: { firstName: 'Gideon', lastName: 'Lin' }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log("页面加载完成", options);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {
    console.log("页面准备完成");
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    console.log("页面显示");
    common.sayHello("张三");
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {
    console.log("页面隐藏");
    common.sayGoodbye("张三");
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {
    console.log("页面卸载");
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    console.log("页面被下拉");
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
    console.log(" 页面上拉触底事件");
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {
    console.log("用户分享页面");
  }
})