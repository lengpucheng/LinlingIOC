# LinlingIOC
一个IOC和AOP框架


# 20/11/30 1.05
## 使用
### 1. 启动
1. 直接运行 `LinLingApplicationMain` 即可
2. 使用入下代码启动，且给主类打上 `Module` 系列注解
```java
    public static void main(String[] args){
      new new ApplicationDeploymentStart(当前类).run(args);
    }
```
### 2. 依赖注入
使用 `Module` 系列注释来标记组件（见下1），在需要依赖时，在字段上使用 `AutoInject` 注释标记，框架会自动注入实例
### 3. 动态代理（AOP）
1. 使用 `AgencyProxyClass` 来标记存在代理方法需要被代理的类,在需要被代理的方法上 加上 `AgencyProxy` 并给其赋值ID，此ID是代理ID
2. 使用 `AgencyProvider` 来标记进行代理的类，其值 为代理ID，会自动代理同ID的类，属性`enable` 是是否启用，默认启用，使用 `AgencyProviderMethod` 来该方法在代理方法执行的位置，默认是后，若该类继承 `Agency` 则可以无需该注解
3. 在代理实现方法中，若在之前执行会有参数 `Obj...` 其为原方法入参，之后执行会有参数 `(Obj rest,Obj... pram)` rest为原方法结果，pram为入参，若只需要入参，第一个参数必须填 `null`
4. 暂时无法使用自动注入，需要手动调用并强转下转
```java
        applicationDeploymentStart.run(args);
        Person person= (Person) applicationDeploymentStart.getApplicationContainer().getContainer().get(Student.class.getName());
```

## 更新内容
1. 完成了动态代理代理和切面相关，相关类在AOP包下

2. 添加了`Agency` 接口

3. 添加了容器接口

添加了 `Container<?>` 接口, 将之前类集 `ApplicationContainer` 修改为实现该接口，进行统一

4. 添加 `AgencyProxyClass` 注解 继承于 `Module`

## 已知问题
1. 目前无法自动加载JAR包下的应用，即——目前使用改依赖构建的应用若打包后运行会报错
2. 目前无法对非接口实现的类进行动态代理，且无法对代理类进行自动注入（基于接口实现，无法自动向上转型）

## 待优化
1. 完成LoadFileJAR
2. 完成代理注入
3. 完成对普通类的继承代理

----

# 20/11/27  1.0
## 使用
1. 直接运行 `LinLingApplicationMain`
2. 使用入下代码启动，且给主类打上 `Module` 系列注解
```java
    public static void main(String[] args){
      new new ApplicationDeploymentStart(当前类).run(args);
    }
```
使用 `Module` 系列注释来标记组件（见下1），在需要依赖时，在字段上使用 `AutoInject` 注释标记，框架会自动注入实例

## 更新内容
1. IOC容器完成

使用 `Module` 来标记组件,`Service`、 `Control`、 `Serviceable`、 `AgencyProvider`以及含有了此标记,，通过使用 `AutoInject` 来标识容器自动依赖注入

2. 外部文件加载器完成

完成了 `LoadFileSRC` 实现 `LoadFile` 接口，通过指定路径或包名加载非JAR包内的文件

3. 类文件加载器完成

完成了 `LoadClassFile` 实现了定义接口 `LoadClass` 通过全类名加载类

4. 完成了应用部署类

完成了IOC.container包下的 类加载、实例化、自动注入相关类，其中 `ApplicationDeploymentStart` 是启动主类，可以直接运行根目录下的 `LinLingApplication` 启动

## 已知问题
目前无法自动加载JAR包下的应用，即——目前使用改依赖构建的应用若打包后运行会报错

## 待优化
1. 完成LoadFileJAR

----
