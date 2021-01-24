App({
  onLaunch(options) {
    // Do something initial when launch.
    console.log("小程序加载成功， 场景 -> " + options.scene);
  },
  onShow(options) {
    console.log("小程序显示");
  },
  onHide() {
    console.log("小程序隐藏");
  },
  onError(msg) {
    console.log(msg)
  },
  globalData: 'I am global data'
})