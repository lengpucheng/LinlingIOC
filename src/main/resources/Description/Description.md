
## IOC容器
1. 使用 `Module` 来标记组件,`Service`、`Control`、`Serviceable`、`AgencyProvider`、 `AgencyProxyClass`  以及含有了此标记, 参数 `value` 标识其默认参数
2. 使用 `Control` 来标记控制类（服务），参数 `value` 用来标记访问标记 , `metohd` 用来标记访问方法,`tag` 标记其标签, `discribe` 标记描述
3. 使用 `Service` 用来标记 接口,参数 `value` 指定实现类
4. 使用 `Serviceable` 来标记接口的实现类,参数 `value` 标识其实现的接口,`version` 标识版本, `priority` 标识优先级
5. 使用 `AutoInject` 来标识自动注入

## AOP切面
1. 使用 `AgencyProxy` 来标记需要被代理的方法，参数 `value` 用于标识代理提供商ID
2. 使用 `AgencyProxyClass` 来标记存在代理方法需要被代理的类
3. 使用 `AgencyProvider` 来标记代理提供者（类），参数 `value` 用于标识对那些代理生效，`version` 标识代理版本（默认1.0), `enable` 标识是否启用该代理(默认启动)
4. 使用 `AgencyProviderMethod` 来标识某一个方法在代理时的执行位置，参数 `value` 标识位置，默认前后