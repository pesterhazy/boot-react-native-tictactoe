var ReactNative = {}

ReactNative.ActionSheetIOS = {}
ReactNative.AdSupportIOS = {}
ReactNative.Alert = {}
ReactNative.AlertIOS = {}
ReactNative.Animated = {}
ReactNative.AppRegistry = {}
ReactNative.AppStateIOS = {}
ReactNative.AsyncStorage = {}
ReactNative.BackAndroid = {}
ReactNative.CameraRoll = {}
ReactNative.Clipboard = {}
ReactNative.Component = {}
ReactNative.DatePickerIOS = {}
ReactNative.DeviceEventEmitter = {}
ReactNative.Dimensions = {}
ReactNative.Easing = {}
ReactNative.Image = {}
ReactNative.ImagePickerIOS = {}
ReactNative.IntentAndroid = {}
ReactNative.InteractionManager = {}
ReactNative.LayoutAnimation = {}
ReactNative.LinkingIOS = {}
ReactNative.ListView = {}
ReactNative.MapView = {}
ReactNative.Modal = {}
ReactNative.NativeAppEventEmitter = {}
ReactNative.NativeModules = {}
ReactNative.Navigator = {}
ReactNative.NavigatorIOS = {}
ReactNative.NetInfo = {}
ReactNative.PanResponder = {}
ReactNative.PickerIOS = {}
ReactNative.PixelRatio = {}
ReactNative.Platform = {}
ReactNative.ProgressBarAndroid = {}
ReactNative.ProgressViewIOS = {}
ReactNative.PullToRefreshViewAndroid = {}
ReactNative.PushNotificationIOS = {}
ReactNative.ScrollView = {}
ReactNative.SegmentedControlIOS = {}
ReactNative.Settings = {}
ReactNative.SliderIOS = {}
ReactNative.SnapshotViewIOS = {}
ReactNative.StatusBarIOS = {}
ReactNative.StyleSheet = {}
ReactNative.Switch = {}
ReactNative.SwitchAndroid = {}
ReactNative.SwitchIOS = {}
ReactNative.TabBarIOS = {}
ReactNative.Text = {}
ReactNative.TextInput = {}
ReactNative.ToastAndroid = {}
ReactNative.ToolbarAndroid = {}
ReactNative.Touchable = {}
ReactNative.TouchableWithoutFeedback = {}
ReactNative.UIManager = {}
ReactNative.VibrationIOS = {}
ReactNative.View = {}
ReactNative.ViewPagerAndroid = {}
ReactNative.WebView = {}
ReactNative.cloneElement = function() {}
ReactNative.createClass = function() {}
ReactNative.createElement = function() {}
ReactNative.createFactory = function() {}
ReactNative.render = function() {}
ReactNative.renderComponent = function() {}
ReactNative.unmountComponentAtNode = function() {}
ReactNative.unmountComponentAtNodeAndRemoveContainer = function() {}

var AppRegistry = {}
AppRegistry.getAppKeys = function() {}
AppRegistry.registerRunnable = function () {}
AppRegistry.registerComponent = function () {}
AppRegistry.registerConfig = function() {}
AppRegistry.runApplication = function() {}
AppRegistry.unmountApplicationComponentAtRootTag = function() {}

var Platform = {}
Platform.OS = {}
Platform.Version = {}

var ListView = {}
ListView.DataSource = function() {}

var DataSource = {}
DataSource.cloneWithRows = function() {}

var Navigator = {}
Navigator.getCurrentRoutes = function() {}
Navigator.jumpBack = function() {}
Navigator.jumpForward = function() {}
Navigator.jumpTo = function() {}
Navigator.push = function() {}
Navigator.pop = function() {}
Navigator.replace = function() {}
Navigator.replaceAtIndex = function() {}
Navigator.replacePrevious = function() {}
Navigator.immediatelyResetRouteStack = function() {}
Navigator.popToRoute = function() {}
Navigator.popToTop = function() {}

var NavigatorIOS = {}
NavigatorIOS.push = function() {}
NavigatorIOS.pop = function() {}
NavigatorIOS.popN = function() {}
NavigatorIOS.replace = function() {}
NavigatorIOS.replacePrevious = function() {}
NavigatorIOS.replacePreviousAndPop = function() {}
NavigatorIOS.resetTo = function() {}
NavigatorIOS.popToRoute = function() {}
NavigatorIOS.popToTop = function() {}

var ActionSheetIOS = {}
ActionSheetIOS.showActionSheetWithOptions = function() {}
ActionSheetIOS.showShareActionSheetWithOptions = function() {}

var Alert = {}
Alert.alert = function() {}

var AlertIOS = {}
AlertIOS.alert = function() {}
AlertIOS.prompt = function() {}

var Animated = {}
Animated.Value = function() {}
Animated.add = function() {}
Animated.addListener = function() {}
Animated.animate = function() {}
Animated.createAnimatedComponent = function() {}
Animated.decay = function() {}
Animated.delay = function() {}
Animated.event = function() {}
Animated.flattenOffset = function() {}
Animated.getLayout = function() {}
Animated.getTranslateTransform = function() {}
Animated.interpolate = function() {}
Animated.multiply = function() {}
Animated.parallel = function() {}
Animated.removeAllListeners = function() {}
Animated.removeListener = function() {}
Animated.sequence = function() {}
Animated.setOffset = function() {}
Animated.setValue = function() {}
Animated.spring = function() {}
Animated.stagger = function() {}
Animated.stopAnimation = function() {}
Animated.stopTracking = function() {}
Animated.timing = function() {}
Animated.track = function() {}

var AppStateIOS = {}
AppStateIOS.currentState = {}
AppStateIOS.addEventListener = function() {}
AppStateIOS.removeEventListener = function() {}

var AsyncStorage = {}
AsyncStorage.getItem = function() {}
AsyncStorage.setItem = function() {}
AsyncStorage.removeItem = function() {}
AsyncStorage.mergeItem = function() {}
AsyncStorage.clear = function() {}
AsyncStorage.getAllKeys = function() {}
AsyncStorage.flushGetRequests = function() {}
AsyncStorage.multiGet = function() {}
AsyncStorage.multiSet = function() {}
AsyncStorage.multiRemove = function() {}
AsyncStorage.multiMerge = function() {}

var BackAndroid = {}
BackAndroid.exitApp = function() {}
BackAndroid.addEventListener = function() {}
BackAndroid.removeEventListener = function() {}

var CameraRoll = {}
CameraRoll.saveImageWithTag = function() {}
CameraRoll.getPhotos = function() {}

var Dimensions = {}
Dimensions.set = function() {}
Dimensions.get = function() {}

var IntentAndroid = {}
IntentAndroid.openURL = function() {}
IntentAndroid.canOpenURL = function() {}
IntentAndroid.getInitialURL = function() {}

var InteractionManager = {}
InteractionManager.runAfterInteractions = function() {}
InteractionManager.createInteractionHandle = function() {}
InteractionManager.clearInteractionHandle = function() {}
InteractionManager.setDeadline = function() {}
InteractionManager.Events = {}
InteractionManager.addListener = {}

var LayoutAnimation = {}
LayoutAnimation.configureNext = function() {}
LayoutAnimation.create = function() {}
LayoutAnimation.Types = {}
LayoutAnimation.Properties = {}
LayoutAnimation.configChecker = {}
LayoutAnimation.Presets = {}
LayoutAnimation.easeInEaseOut = {}
LayoutAnimation.linear = {}
LayoutAnimation.spring = {}

var LinkingIOS = {}
LinkingIOS.addEventListener = function() {}
LinkingIOS.removeEventListener = function() {}
LinkingIOS.openURL = function() {}
LinkingIOS.canOpenURL = function() {}
LinkingIOS.popInitialURL = function() {}

var NativeMethodsMixin = {}
NativeMethodsMixin.measure = function() {}
NativeMethodsMixin.measureLayout = function() {}
NativeMethodsMixin.setNativeProps = function() {}
NativeMethodsMixin.focus = function() {}
NativeMethodsMixin.blur = function() {}

var NetInfo = {}
NetInfo.isConnectionExpensive = function() {}
NetInfo.isConnected = function() {}
NetInfo.addEventListener = function() {}
NetInfo.removeEventListener = function() {}
NetInfo.fetch = function() {}
NetInfo.isConnectionExpensive = function() {}

var PanResponder = {}
PanResponder.create = function() {}
PanResponder.onMoveShouldSetPanResponder = {}
PanResponder.onMoveShouldSetPanResponderCapture = {}
PanResponder.onStartShouldSetPanResponder = {}
PanResponder.onStartShouldSetPanResponderCapture = {}
PanResponder.onPanResponderReject = {}
PanResponder.onPanResponderGrant = {}
PanResponder.onPanResponderStart = {}
PanResponder.onPanResponderEnd = {}
PanResponder.onPanResponderRelease = {}
PanResponder.onPanResponderMove = {}
PanResponder.onPanResponderTerminate = {}
PanResponder.onPanResponderTerminationRequest = {}

var PixelRatio = {}
PixelRatio.get = function() {}
PixelRatio.getFontScale = function() {}
PixelRatio.getPixelSizeForLayoutSize = function() {}
PixelRatio.startDetecting = function() {}

var PushNotificationIOS = {}
PushNotificationIOS.presentLocalNotification = function() {}
PushNotificationIOS.scheduleLocalNotification = function() {}
PushNotificationIOS.cancelAllLocalNotifications = function() {}
PushNotificationIOS.setApplicationIconBadgeNumber = function() {}
PushNotificationIOS.getApplicationIconBadgeNumber = function() {}
PushNotificationIOS.addEventListener = function() {}
PushNotificationIOS.requestPermissions = function() {}
PushNotificationIOS.abandonPermissions = function() {}
PushNotificationIOS.checkPermissions = function() {}
PushNotificationIOS.alert = {}
PushNotificationIOS.badge = {}
PushNotificationIOS.sound = {}
PushNotificationIOS.removeEventListener = function() {}
PushNotificationIOS.popInitialNotification = function() {}
PushNotificationIOS.getMessage = function() {}
PushNotificationIOS.getSound = function() {}
PushNotificationIOS.getAlert = function() {}
PushNotificationIOS.getBadgeCount = function() {}
PushNotificationIOS.getData = function() {}

var StatusBarIOS = {}
StatusBarIOS.setStyle = function() {}
StatusBarIOS.setHidden = function() {}
StatusBarIOS.setNetworkActivityIndicatorVisible = function() {}

var StyleSheet = {}
StyleSheet.create = function() {}

var ToastAndroid = {}
ToastAndroid.show = function() {}
ToastAndroid.SHORT = {}
ToastAndroid.LONG = {}

var VibrationIOS = {}
VibrationIOS.vibrate = function() {}

var geolocation = {}
geolocation.getCurrentPosition = function() {}
geolocation.watchPosition = function() {}
geolocation.clearWatch = function() {}
geolocation.stopObserving = function() {}
