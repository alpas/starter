let mix = require('laravel-mix')
const resourcesPath = 'src/main/resources'
const publicPath = `${resourcesPath}/web`

mix
    .setPublicPath(publicPath)
    .js(`${resourcesPath}/js/app.js`, 'js')
    .sass(`${resourcesPath}/sass/app.scss`, 'css')
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
