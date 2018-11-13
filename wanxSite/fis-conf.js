fis.match('*.{js,css,png,jpg,gif,jpeg,eot,svg,ttf,woff,otf}',{
	release:'/wanxSite/$0'
})
//压缩资源
fis.match('*.js', {
  useHash: true,
  optimizer: fis.plugin('uglify-js')
});

fis.match('*.css', {
  useHash: true,
  optimizer: fis.plugin('clean-css')
});

// fis.match('*.png', {
//   useHash: true
// });
// fis.match('*.jpg', {
// 	useHash: true
// });