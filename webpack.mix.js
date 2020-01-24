let mix = require('laravel-mix')
const tailwindcss = require('tailwindcss')
const resourcesPath = 'src/main/resources'
const publicPath = `${resourcesPath}/web`

mix
    .setPublicPath(publicPath)
    .js(`${resourcesPath}/js/app.js`, 'js')
    .less(`${resourcesPath}/css/app.less`, 'css')
    .options({postCss: [tailwindcss('./tailwind.config.js')]})
    .disableNotifications()

if (mix.inProduction()) {
    mix.version()
} else {
    mix.browserSync({
        open: false,
        notify: false,
        proxy: `localhost:${process.env.MIX_APP_PORT}`,
        files: [
            'out/**/*',
            `${publicPath}`,
        ],
    })
}
