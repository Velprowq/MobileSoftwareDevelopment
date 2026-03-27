# Lab2 ：使用 Jetpack Compose 构建名片应用

## 一、名片展示的个人信息
- 姓名：卢诗雅
- 职位：Android 开发工程师
- 电话：+86 138-8738-6676
- 邮箱：2110131725@qq.com
- 社交账号：@balaba

## 二、布局结构简要说明
本次使用 Jetpack Compose 实现名片应用，界面分为上下两个区域。
主要使用的 Composable 组件：Column、Row、Box、Image、Text、Divider、Spacer。

布局结构：
1. 最外层使用 Column 纵向布局，按 6:4 的权重分为上下两部分。
2. 上半部分使用 Box 堆叠布局，底层为背景图片，上层用 Column 居中展示圆形头像、姓名、职位。
3. 下半部分使用 Column 加浅粉色背景，通过 Row 实现“图标+文字”的联系方式列表，并用 Divider 分隔。
4. 联系方式行封装为 ContactRow，使用 Image 显示本地图标，Text 显示信息。

## 三、遇到的问题和解决过程
1. 背景图片拉伸变形
   解决：给 Image 设置 contentScale = ContentScale.Crop，保持比例并裁剪填充。

2. 头像无法显示为圆形
   解决：使用 Modifier.clip(CircleShape) 将头像裁剪成圆形。

3. 本地图标无法统一上色
   解决：使用 ColorFilter.tint(accentColor) 为图标设置主题粉色。

4. 不同手机屏幕布局比例错乱
   解决：使用 weight 权重分配上下区域高度，实现屏幕适配。

5. Scaffold 背景覆盖自定义背景
   解决：设置 Scaffold 的 containerColor，并正确使用 Modifier 顺序。

## 四、实验总结
本次实验通过 Jetpack Compose 成功完成了电子名片界面开发，掌握了声明式 UI 的基本写法，熟练使用 Column、Row、Box 进行界面布局，能够运用 Image、Text、Divider 等组件搭建完整界面。同时学会使用 Modifier 实现裁剪、间距、对齐、背景、填充等样式控制，能够封装可组合函数提升代码复用性，解决了图片拉伸、圆形头像、图标上色、屏幕适配等常见问题。本次名片设计让我对 Compose 声明式编程有了更清晰的认识，为后续 Android UI 开发打下了扎实基础。