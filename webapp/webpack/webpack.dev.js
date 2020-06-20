const webpack = require('webpack');
const writeFilePlugin = require('write-file-webpack-plugin');
const webpackMerge = require('webpack-merge');
const BrowserSyncPlugin = require('browser-sync-webpack-plugin');
const FriendlyErrorsWebpackPlugin = require('friendly-errors-webpack-plugin');
const SimpleProgressWebpackPlugin = require('simple-progress-webpack-plugin');
const WebpackNotifierPlugin = require('webpack-notifier');
const path = require('path');
const sass = require('sass');

const utils = require('./utils.js');
const commonConfig = require('./webpack.common.js');

const ENV = 'development';

module.exports = (options) => webpackMerge(commonConfig({ env: ENV }), {
  devtool: 'cheap-module-source-map', // https://reactjs.org/docs/cross-origin-errors.html
  mode: ENV,
  entry: [
    './src/main/webapp/app/index'
  ],
  output: {
    path: utils.root('build/resources/main/static/'),
    filename: 'app/[name].bundle.js',
    chunkFilename: 'app/[id].chunk.js'
  },
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: ['style-loader', 'css-loader', 'postcss-loader', {
            loader: 'sass-loader',
            options: { implementation: sass }
          }
        ]
      }
    ]
  },
  stats: process.env.JHI_DISABLE_WEBPACK_LOGS ? 'none' : options.stats,
  plugins: [
    process.env.JHI_DISABLE_WEBPACK_LOGS
      ? null
      : new SimpleProgressWebpackPlugin({
          format: options.stats === 'minimal' ? 'compact' : 'expanded'
        }),
    new FriendlyErrorsWebpackPlugin(),
    new BrowserSyncPlugin({
      https: options.tls,
      host: 'localhost',
      port: 9000,
      proxy: {
        target: `http${options.tls ? 's' : ''}://localhost:9060`,
          proxyOptions: {
              changeOrigin: false  //pass the Host header to the backend unchanged  https://github.com/Browsersync/browser-sync/issues/430
          }
      },
      socket: {
        clients: {
          heartbeatTimeout: 60000
        }
      }
      /*
      ,ghostMode: { // uncomment this part to disable BrowserSync ghostMode; https://github.com/jhipster/generator-jhipster/issues/11116
        clicks: false,
        location: false,
        forms: false,
        scroll: false
      } */
    }, {
      reload: false
    }),
    new webpack.NamedModulesPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new writeFilePlugin(),
    new webpack.WatchIgnorePlugin([
      utils.root('src/test'),
    ]),
    new WebpackNotifierPlugin({
      title: 'covider',
      contentImage: path.join(__dirname, 'logo192.png')
    })
  ].filter(Boolean)
});
