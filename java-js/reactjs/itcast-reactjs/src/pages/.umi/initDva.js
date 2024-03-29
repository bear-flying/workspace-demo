import dva from 'dva';
import createLoading from 'dva-loading';

const runtimeDva = window.g_plugins.mergeConfig('dva');
let app = dva({
  history: window.g_history,
  
  ...(runtimeDva.config || {}),
});

window.g_app = app;
app.use(createLoading());
(runtimeDva.plugins || []).forEach(plugin => {
  app.use(plugin);
});

app.model({ namespace: 'ListData', ...(require('F:/code/itcast-reactjs/src/models/ListData.js').default) });
app.model({ namespace: 'UserListData', ...(require('F:/code/itcast-reactjs/src/models/UserListData.js').default) });
