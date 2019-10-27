let mix = require('laravel-mix')
const publicPath = 'src/main/resources/web'
const assetsPath = 'src/main/assets'

mix
    .setPublicPath(publicPath)
    .js(`${assetsPath}/js/app.js`, 'js')
    .sass(`${assetsPath}/sass/app.scss`, 'css')
    .version()
    .disableNotifications()

if (!mix.inProduction()) {
    mix.browserSync({
        proxy: `localhost:${process.env.MIX_APP_PORT}`,
        notify: false,
        open: false,
        files: [
            'build/**/*',
            `${publicPath}/js/**/*.js`,
            `${publicPath}/css/**/*.css`
        ],
    })
}
